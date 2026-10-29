package nelson.rsfred.hubapp.ui.composable.screen.high_scores

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.data.entity.HighScore
import nelson.rsfred.hubapp.ui.composable.approot.topbar.AppTopBar
import nelson.rsfred.hubapp.ui.composable.screen.high_scores.card.HighScoreCardItem
import nelson.rsfred.hubapp.ui.composable.screen.high_scores.card.HighScoreCard
import nelson.rsfred.hubapp.ui.composable.screen.high_scores.filter.HighScoreFilter
import nelson.rsfred.hubapp.ui.composable.screen.shared.DataBasedContainer
import nelson.rsfred.hubapp.ui.composable.screen.shared.DataEmptyContent
import nelson.rsfred.hubapp.ui.state.DataUiState
import nelson.rsfred.hubapp.ui.theme.LocalDimens
import nelson.rsfred.hubapp.ui.viewmodel.HighScoreViewModel
import java.time.format.DateTimeFormatter

private val DateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy")

@Composable
fun NOFHPHighScoresScreen(
    modifier: Modifier = Modifier,
    viewModel: HighScoreViewModel = koinViewModel(),
    onBackClick: () -> Unit,
) {
    val highScoresState by viewModel.highScoresState.collectAsState()
    val selectedSortType by viewModel.selectedSortTypeState.collectAsState()
    val dimens = LocalDimens.current

    Column(modifier = modifier.fillMaxSize()) {
        AppTopBar(
            title = stringResource(R.string.high_scores_title),
            onNavigateBack = onBackClick,
        )

        DataBasedContainer(
            modifier = Modifier.weight(1f),
            dataState = highScoresState,
            dataPopulated = {
                val highScores = (highScoresState as DataUiState.Populated).data

                Column(modifier = Modifier.fillMaxSize()) {
                    HighScoreFilter(
                        selected = selectedSortType,
                        onSelect = viewModel::onSortTypeSelected,
                        modifier = Modifier.padding(
                            horizontal = dimens.screenPadding,
                            vertical = dimens.contentSpacing,
                        ),
                    )

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(
                            start = dimens.screenPadding,
                            end = dimens.screenPadding,
                            bottom = dimens.contentSpacing,
                        ),
                        verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
                    ) {
                        items(highScores, key = HighScore::id) { highScore ->
                            HighScoreCard(
                                item = HighScoreCardItem(
                                    correctAnswers = highScore.rightAnswers,
                                    totalQuestions = highScore.questions,
                                    formattedDate = highScore.timestamp.format(DateFormatter),
                                ),
                            )
                        }
                    }
                }
            },
            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.high_scores_empty),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}

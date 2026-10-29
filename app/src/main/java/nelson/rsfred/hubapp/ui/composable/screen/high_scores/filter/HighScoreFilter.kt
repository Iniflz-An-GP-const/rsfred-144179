package nelson.rsfred.hubapp.ui.composable.screen.high_scores.filter

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.data.model.HighScoreSortType

/** One wide segmented control instead of separate chips — all options always visible, no scrolling. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HighScoreFilter(
    selected: HighScoreSortType,
    onSelect: (HighScoreSortType) -> Unit,
    modifier: Modifier = Modifier,
) {
    val options: List<Triple<HighScoreSortType, String, ImageVector>> = listOf(
        Triple(
            HighScoreSortType.RIGHT_ANSWERS,
            stringResource(R.string.high_scores_filter_score),
            Icons.Filled.EmojiEvents,
        ),
        Triple(
            HighScoreSortType.QUESTIONS,
            stringResource(R.string.high_scores_filter_questions),
            Icons.Filled.Numbers,
        ),
        Triple(
            HighScoreSortType.DATE,
            stringResource(R.string.high_scores_filter_date),
            Icons.Filled.DateRange,
        ),
    )

    SingleChoiceSegmentedButtonRow(modifier = modifier.fillMaxWidth()) {
        options.forEachIndexed { index, (sortType, label, icon) ->
            SegmentedButton(
                selected = selected == sortType,
                onClick = { onSelect(sortType) },
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(SegmentedButtonDefaults.IconSize),
                    )
                },
                label = { Text(text = label) },
            )
        }
    }
}

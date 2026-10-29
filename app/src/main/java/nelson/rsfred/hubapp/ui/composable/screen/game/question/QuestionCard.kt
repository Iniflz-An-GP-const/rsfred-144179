package nelson.rsfred.hubapp.ui.composable.screen.game.question

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.ui.composable.screen.game.question.QuestionCardDefaults
import nelson.rsfred.hubapp.ui.composable.screen.game.question.QuestionCardItem
import nelson.rsfred.hubapp.ui.theme.LocalDimens
import nelson.rsfred.hubapp.ui.theme.cardBorderStroke

/** A small "Question X of Y" label sits above the question text. */
@Composable
fun QuestionCard(
    item: QuestionCardItem,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = QuestionCardDefaults.shape
    val border = cardBorderStroke()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = shape)
            .let { base -> if (border != null) base.border(border, shape) else base }
            .padding(QuestionCardDefaults.padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing),
    ) {
        Text(
            text = stringResource(
                R.string.question_card_progress_format,
                item.questionNumber,
                item.totalQuestions,
            ),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = item.text,
            style = QuestionCardDefaults.textStyle(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

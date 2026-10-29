package nelson.rsfred.hubapp.ui.composable.screen.high_scores.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.ui.composable.screen.high_scores.card.HighScoreCardDefaults
import nelson.rsfred.hubapp.ui.composable.screen.high_scores.card.HighScoreCardItem
import nelson.rsfred.hubapp.ui.theme.LocalDimens
import nelson.rsfred.hubapp.ui.theme.cardBorderStroke

private val BadgeSize = 44.dp
private val BadgeIconSize = 24.dp
private const val GoldThreshold = 90
private const val SilverThreshold = 70
private const val BronzeThreshold = 50

/** The medal color is chosen by the actual accuracy — the data decides the look, not just the selection state. */
@Composable
fun HighScoreCard(
    item: HighScoreCardItem,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = HighScoreCardDefaults.shape
    val border = cardBorderStroke()

    val medalColor = medalColorFor(item.accuracyPercent)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(color = MaterialTheme.colorScheme.surfaceContainer, shape = shape)
            .let { base -> if (border != null) base.border(border, shape) else base }
            .padding(HighScoreCardDefaults.padding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
    ) {
        Box(
            modifier = Modifier
                .size(BadgeSize)
                .background(color = medalColor, shape = CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.EmojiEvents,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(BadgeIconSize),
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing)) {
            Text(
                text = stringResource(R.string.high_score_card_score_format, item.correctAnswers, item.totalQuestions),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                text = item.formattedDate,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun medalColorFor(accuracyPercent: Int): Color = when {
    accuracyPercent >= GoldThreshold -> MaterialTheme.colorScheme.primary
    accuracyPercent >= SilverThreshold -> MaterialTheme.colorScheme.secondary
    accuracyPercent >= BronzeThreshold -> MaterialTheme.colorScheme.tertiary
    else -> MaterialTheme.colorScheme.outline
}

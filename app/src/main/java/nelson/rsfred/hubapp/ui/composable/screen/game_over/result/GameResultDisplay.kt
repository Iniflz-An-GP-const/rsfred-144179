package nelson.rsfred.hubapp.ui.composable.screen.game_over.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.ui.composable.screen.game_over.result.GameResultItem
import nelson.rsfred.hubapp.ui.theme.LocalDimens

private val BadgeSize = 88.dp
private val BadgeIconSize = 48.dp
private const val GoldThreshold = 90
private const val SilverThreshold = 70
private const val BronzeThreshold = 50

/** Medal color is chosen by the actual accuracy, same tiers as the high-score card's v_medal. */
@Composable
fun GameResultDisplay(
    item: GameResultItem,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val medalColor = medalColorFor(item.accuracyPercent)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
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

        Text(
            text = stringResource(
                R.string.high_score_card_score_format,
                item.correctAnswers,
                item.totalQuestions,
            ),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Composable
private fun medalColorFor(accuracyPercent: Int): Color = when {
    accuracyPercent >= GoldThreshold -> MaterialTheme.colorScheme.primary
    accuracyPercent >= SilverThreshold -> MaterialTheme.colorScheme.secondary
    accuracyPercent >= BronzeThreshold -> MaterialTheme.colorScheme.tertiary
    else -> MaterialTheme.colorScheme.outline
}

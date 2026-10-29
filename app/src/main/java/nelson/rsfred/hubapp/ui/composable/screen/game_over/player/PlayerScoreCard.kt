package nelson.rsfred.hubapp.ui.composable.screen.game_over.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.ui.composable.screen.game_over.player.PlayerScoreItem
import nelson.rsfred.hubapp.ui.theme.LocalDimens

/** The winner's whole card fills with a tinted color — simplest possible signal. */
@Composable
fun PlayerScoreCard(
    item: PlayerScoreItem,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = RoundedCornerShape(dimens.cardCornerRadius)

    val containerColor = if (item.isWinner) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }
    val contentColor = if (item.isWinner) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Column(
        modifier = modifier
            .background(color = containerColor, shape = shape)
            .padding(dimens.cardPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing),
    ) {
        Text(
            text = stringResource(R.string.game_over_player_format, item.playerNumber),
            style = MaterialTheme.typography.labelLarge,
            color = contentColor,
        )
        Text(
            text = "${item.correctAnswers}/${item.totalQuestions}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = contentColor,
        )
    }
}

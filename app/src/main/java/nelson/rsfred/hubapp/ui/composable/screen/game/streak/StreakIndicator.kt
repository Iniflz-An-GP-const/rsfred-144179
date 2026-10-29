package nelson.rsfred.hubapp.ui.composable.screen.game.streak

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.ui.composable.screen.game.streak.StreakItem

/** No chrome at all — just bold, colored text. The plainest possible read. */
@Composable
fun StreakIndicator(
    item: StreakItem,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(R.string.streak_in_a_row_format, item.count),
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
    )
}

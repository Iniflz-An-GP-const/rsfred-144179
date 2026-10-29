package nelson.rsfred.hubapp.ui.composable.screen.high_scores.card

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import nelson.rsfred.hubapp.ui.theme.LocalDimens

/** Shared look of every high-score card variant — shape and padding come from [LocalDimens]. */
internal object HighScoreCardDefaults {
    val shape: Shape
        @Composable get() = RoundedCornerShape(LocalDimens.current.cardCornerRadius)

    val padding: Dp
        @Composable get() = LocalDimens.current.cardPadding
}

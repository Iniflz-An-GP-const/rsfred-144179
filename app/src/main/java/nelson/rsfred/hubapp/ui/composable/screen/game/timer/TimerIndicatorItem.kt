package nelson.rsfred.hubapp.ui.composable.screen.game.timer

data class TimerIndicatorItem(
    /** 1f = full time remaining, 0f = out of time. */
    val progress: Float,
    val remainingSeconds: Int,
)

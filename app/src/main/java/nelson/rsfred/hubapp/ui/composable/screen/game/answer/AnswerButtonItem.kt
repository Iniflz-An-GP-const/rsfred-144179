package nelson.rsfred.hubapp.ui.composable.screen.game.answer

enum class AnswerState {
    Neutral,
    Correct,
    Wrong,
}

data class AnswerButtonItem(
    val text: String,
    val state: AnswerState = AnswerState.Neutral,
    val letter: Char? = null,
)

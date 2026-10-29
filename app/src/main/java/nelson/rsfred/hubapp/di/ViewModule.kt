package nelson.rsfred.hubapp.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import nelson.rsfred.hubapp.ui.viewmodel.GameViewModel
import nelson.rsfred.hubapp.ui.viewmodel.HighScoreViewModel
import nelson.rsfred.hubapp.ui.viewmodel.TopicsSelectionViewModel

val viewModule = module {
    viewModel {
        TopicsSelectionViewModel(topicRepository = get())
    }

    viewModel {
        GameViewModel(
            savedStateHandle = get(),
            topicRepository = get(),
            highScoreRepository = get()
        )
    }

    viewModel {
        HighScoreViewModel(
            highScoreRepository = get()
        )
    }
}
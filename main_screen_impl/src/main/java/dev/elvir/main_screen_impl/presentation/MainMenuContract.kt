package dev.elvir.main_screen_impl.presentation

import dev.elvir.core.base.BaseMvp

class MainMenuContract {

    interface View: BaseMvp.View {
        fun showCurrentData(title : String)
    }

    interface Presenter: BaseMvp.Presenter<View> {
        fun loadInitData()
    }
}
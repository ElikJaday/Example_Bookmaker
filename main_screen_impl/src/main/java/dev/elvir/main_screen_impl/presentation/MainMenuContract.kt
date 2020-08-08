package dev.elvir.main_screen_impl.presentation

import dev.elvir.bookmaker_provider_api.data.model.BookmakerRatingsModel
import dev.elvir.bookmaker_provider_api.data.model.ForecastModel
import dev.elvir.core.base.BaseMvp

class MainMenuContract {

    interface View : BaseMvp.View {
        fun showOrUpdateBookmakerRatings(bookmakerRatingList: List<BookmakerRatingsModel>)
        fun showOrUpdateForecast(forecastList: List<ForecastModel>)
    }

    interface Presenter : BaseMvp.Presenter<View> {
        fun loadInitData()
    }
}
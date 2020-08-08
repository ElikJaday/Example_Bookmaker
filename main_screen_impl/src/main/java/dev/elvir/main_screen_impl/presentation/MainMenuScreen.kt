package dev.elvir.main_screen_impl.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import dev.elvir.bookmaker_provider_api.data.model.BookmakerRatingsModel
import dev.elvir.bookmaker_provider_api.data.model.ForecastModel
import dev.elvir.main_screen_impl.ComponentManager
import dev.elvir.main_screen_impl.R
import dev.elvir.main_screen_impl.adapter.BookmakerRatingAdapter
import dev.elvir.main_screen_impl.adapter.ForecastFeedAdapter
import kotlinx.android.synthetic.main.main_menu_content.*
import javax.inject.Inject

class MainMenuScreen : AppCompatActivity(), MainMenuContract.View {

    @Inject
    lateinit var presenter: MainMenuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.inject(this)
        presenter.attach(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_sreen_container)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white_transparent)
        setUpWidgets()
        presenter.loadInitData()

    }

    private fun setUpWidgets() {
        book_maker_rating_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        book_maker_forecast_feed.layoutManager = LinearLayoutManager(this)
    }

    override fun showOrUpdateBookmakerRatings(bookmakerRatingList: List<BookmakerRatingsModel>) {
        book_maker_rating_list.adapter = BookmakerRatingAdapter(this, bookmakerRatingList)
    }

    override fun showOrUpdateForecast(forecastList: List<ForecastModel>) {
        book_maker_forecast_feed.adapter = ForecastFeedAdapter(this, forecastList) {
            Toast.makeText(this, "Click handler", Toast.LENGTH_LONG).show()
        }
    }
}
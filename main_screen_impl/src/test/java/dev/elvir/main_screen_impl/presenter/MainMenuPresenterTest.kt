package dev.elvir.main_screen_impl.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.elvir.bookmaker_provider_api.data.repository.BookmakerRatingRepository
import dev.elvir.bookmaker_provider_api.data.repository.ForecastRepository
import dev.elvir.main_screen_impl.presentation.MainMenuContract
import dev.elvir.main_screen_impl.presentation.MainMenuPresenter
import io.reactivex.Single
import org.junit.Test

class MainMenuPresenterTest {


    private lateinit var presenter: MainMenuPresenter
    private lateinit var bookmakerRatingRepository: BookmakerRatingRepository
    private lateinit var forecastRepository: ForecastRepository
    private var view: MainMenuContract.View = mock()

    @Test
    fun check_load_init_data_success() {
        //mock
        forecastRepository = mock()
        whenever(forecastRepository.getAllForecast()).thenReturn(Single.just(listOf()))
        bookmakerRatingRepository = mock()
        whenever(bookmakerRatingRepository.getAllBookmakersRating()).thenReturn(Single.just(listOf()))
        presenter = MainMenuPresenter(bookmakerRatingRepository, forecastRepository)

        //action
        presenter.loadInitData()

        //verify
        verify(forecastRepository).getAllForecast()
        verify(bookmakerRatingRepository).getAllBookmakersRating()

    }

}

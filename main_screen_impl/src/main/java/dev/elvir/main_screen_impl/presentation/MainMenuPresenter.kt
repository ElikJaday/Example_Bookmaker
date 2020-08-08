package dev.elvir.main_screen_impl.presentation

import dev.elvir.bookmaker_provider_api.data.model.BookmakerRatingsModel
import dev.elvir.bookmaker_provider_api.data.model.ForecastModel
import dev.elvir.bookmaker_provider_api.data.repository.BookmakerRatingRepository
import dev.elvir.bookmaker_provider_api.data.repository.ForecastRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainMenuPresenter @Inject constructor(
    private val bookmakerRatingRepository: BookmakerRatingRepository,
    private val forecastRepository: ForecastRepository
) : MainMenuContract.Presenter {

    private var view: MainMenuContract.View? = null
    private val subscriptions = CompositeDisposable()

    override fun attach(view: MainMenuContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
        subscriptions.clear()
    }

    override fun loadInitData() {
        subscriptions.add(
            Single.zip(
                bookmakerRatingRepository.getAllBookmakersRating(),
                forecastRepository.getAllForecast(),
                BiFunction { t1: List<BookmakerRatingsModel>,
                             t2: List<ForecastModel> ->
                    t1 to t2
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showOrUpdateBookmakerRatings(it.first)
                    view?.showOrUpdateForecast(it.second)
                }, {

                })
        )
    }
}
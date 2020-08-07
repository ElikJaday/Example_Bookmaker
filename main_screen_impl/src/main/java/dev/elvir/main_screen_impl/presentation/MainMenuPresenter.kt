package dev.elvir.main_screen_impl.presentation

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainMenuPresenter @Inject constructor(
    private val title : String
) : MainMenuContract.Presenter {

    private var view: MainMenuContract.View? = null
    private val subscriptions = CompositeDisposable()


    override fun loadInitData() {
       view?.showCurrentData(title)
    }

    override fun unsubscribe() {
        TODO("Not yet implemented")
    }

    override fun attach(view: MainMenuContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
        subscriptions.clear()
    }

}
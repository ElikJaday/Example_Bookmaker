package dev.elvir.main_screen_impl.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.main_screen_impl.ComponentManager
import dev.elvir.main_screen_impl.R
import kotlinx.android.synthetic.main.main_menu_sreen_container.*
import javax.inject.Inject

class MainMenuScreen : AppCompatActivity(), MainMenuContract.View {

    @Inject
    lateinit var presenter: MainMenuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.inject(this)
        presenter.attach(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_sreen_container)
        presenter.loadInitData()

    }

    override fun showCurrentData(title: String) {
        tv_title.text = title
    }
}
package dev.elvir.main_screen_impl.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.main_screen_impl.R

class MainMenuScreen  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_sreen_container)
    }
}
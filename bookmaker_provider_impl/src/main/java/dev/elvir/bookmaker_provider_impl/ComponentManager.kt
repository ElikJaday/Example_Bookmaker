package dev.elvir.bookmaker_provider_impl

import android.content.Context
import dev.elvir.bookmaker_provider_impl.di.BookmakerComponent
import dev.elvir.bookmaker_provider_impl.di.DaggerBookmakerComponent

object ComponentManager {

    private lateinit var bookmakerComponent: BookmakerComponent

    private fun plusMainScreenComponent(): BookmakerComponent {
        return DaggerBookmakerComponent.builder()
            .build()
            .also { bookmakerComponent = it }
    }

    fun getBookmakerComponent(context: Context): BookmakerComponent {
        return if (this::bookmakerComponent.isInitialized) {
            bookmakerComponent
        } else {
            plusMainScreenComponent()
        }
    }
}
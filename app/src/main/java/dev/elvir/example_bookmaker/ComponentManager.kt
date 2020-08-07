package dev.elvir.example_bookmaker

import android.content.Context
import dev.elvir.bookmaker_provider_api.BookmakerProviderApi
import dev.elvir.example_bookmaker.di.AppComponent
import dev.elvir.example_bookmaker.di.DaggerAppComponent
import dev.elvir.main_screen_api.MainScreenApi

/**
 * @author Elvir
 * Created by ElikJaday on 07/08/2020.
 * @see
 * Visit my GitHub
 * https://github.com/ElikJaday
 */
class ComponentManager {

    private lateinit var appComponent: AppComponent

    private val mainScreenComponent by lazy {
        dev.elvir.main_screen_impl.ComponentManager
    }
    private val bookmakerProviderComponent by lazy {
        dev.elvir.bookmaker_provider_impl.ComponentManager
    }

    fun plusAppComponent(): AppComponent = DaggerAppComponent
        .builder()
        .build().also { appComponent = it }


    fun <T> componentBuilder(
        api: Class<T>,
        context: Context
    ): T {
        return when (api) {
            MainScreenApi::class.java -> mainScreenComponent.getMainScreenComponent(context)
            BookmakerProviderApi::class.java -> bookmakerProviderComponent.getBookmakerComponent(context)
            else -> throw RuntimeException("component API not found ")
        } as T
    }


}
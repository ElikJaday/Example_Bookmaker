package dev.elvir.main_screen_impl

import android.content.Context
import dev.elvir.bookmaker_provider_api.BookmakerProviderApi
import dev.elvir.core.feature_component.DependencyManager
import dev.elvir.main_screen_api.MainScreenApi
import dev.elvir.main_screen_impl.di.DaggerMainScreenComponent
import dev.elvir.main_screen_impl.di.DaggerMainScreenComponent_MainScreenInnerComponent
import dev.elvir.main_screen_impl.di.MainScreenComponent
import dev.elvir.main_screen_impl.presentation.MainMenuScreen

object ComponentManager {

    private lateinit var mainComponent: MainScreenComponent

    private fun plusMainScreenComponent(): MainScreenComponent {
        return DaggerMainScreenComponent.builder()
            .build()
            .also { mainComponent = it }
    }

    fun getMainScreenComponent(context: Context): MainScreenComponent {
        return if (this::mainComponent.isInitialized) {
            mainComponent
        } else {
            plusMainScreenComponent()
        }
    }

    fun inject(activity: MainMenuScreen) {
        DaggerMainScreenComponent_MainScreenInnerComponent.builder()
            .mainScreenApi(
                DependencyManager.getFeatureDependecy(
                    activity,
                    MainScreenApi::class.java
                )
            )
            .bookmakerProviderApi(
                DependencyManager.getFeatureDependecy(
                    activity,
                    BookmakerProviderApi::class.java
                )
            )
            .build()
            .inject(activity)
    }

}
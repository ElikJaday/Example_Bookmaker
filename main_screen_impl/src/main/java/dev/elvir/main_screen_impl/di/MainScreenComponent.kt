package dev.elvir.main_screen_impl.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dev.elvir.bookmaker_provider_api.BookmakerProviderApi
import dev.elvir.main_screen_api.MainScreenApi
import dev.elvir.main_screen_impl.presentation.MainMenuContract
import dev.elvir.main_screen_impl.presentation.MainMenuPresenter
import dev.elvir.main_screen_impl.presentation.MainMenuScreen
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainScreenScope


@Component(
    modules = [
        MainScreenModule::class
    ]
)
@MainScreenScope
interface MainScreenComponent : MainScreenApi {

    @Component(
        dependencies = [
            MainScreenApi::class,
            BookmakerProviderApi::class
        ]
    )
    @MainScreenScope
    interface MainScreenInnerComponent {
        fun inject(activity: MainMenuScreen)
    }

}


//здесь должны храниться данные которые надо делить с остальными модулями
@Module
class MainScreenModule {
    @Provides
    @MainScreenScope
    fun providePresenter(title : String) = MainMenuPresenter(title)
}


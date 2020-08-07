package dev.elvir.bookmaker_provider_impl.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dev.elvir.bookmaker_provider_api.BookmakerProviderApi

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class BookmakerScope


@Component(
    modules = [
        BookmakerModule::class
    ]
)
@BookmakerScope
interface BookmakerComponent : BookmakerProviderApi {
}


@Module
class BookmakerModule {

    @Provides
    @BookmakerScope
    fun provideDataString() = "Hello Elik from another module"
}

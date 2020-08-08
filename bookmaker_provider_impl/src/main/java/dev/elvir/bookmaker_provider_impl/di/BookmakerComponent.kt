package dev.elvir.bookmaker_provider_impl.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dev.elvir.bookmaker_provider_api.BookmakerProviderApi
import dev.elvir.bookmaker_provider_api.data.repository.BookmakerRatingRepository
import dev.elvir.bookmaker_provider_api.data.repository.ForecastRepository
import dev.elvir.bookmaker_provider_impl.data.repository.BookmakerRatingsStubRepository
import dev.elvir.bookmaker_provider_impl.data.repository.ForecastStubRepository
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
interface BookmakerComponent : BookmakerProviderApi

@Module
class BookmakerModule {

    @Provides
    @BookmakerScope
    fun provideBookmakerRatingRepository(): BookmakerRatingRepository =
        BookmakerRatingsStubRepository()

    @Provides
    @BookmakerScope
    fun provideForecastRepository(): ForecastRepository = ForecastStubRepository()
}

package dev.elvir.bookmaker_provider_api

import dev.elvir.bookmaker_provider_api.data.repository.BookmakerRatingRepository
import dev.elvir.bookmaker_provider_api.data.repository.ForecastRepository

interface BookmakerProviderApi {
    fun provideBookmakerRepository(): BookmakerRatingRepository
    fun provideForecastRepository(): ForecastRepository
}
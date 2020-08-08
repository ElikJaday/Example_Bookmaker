package dev.elvir.bookmaker_provider_api.data.repository

import dev.elvir.bookmaker_provider_api.data.model.ForecastModel
import io.reactivex.Single

interface ForecastRepository {
    fun getAllForecast(): Single<List<ForecastModel>>
}
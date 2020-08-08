package dev.elvir.bookmaker_provider_impl.data.repository

import dev.elvir.bookmaker_provider_api.data.model.ForecastModel
import dev.elvir.bookmaker_provider_api.data.model.ForecastType
import dev.elvir.bookmaker_provider_api.data.repository.ForecastRepository
import dev.elvir.bookmaker_provider_impl.data.model.ForecastStubModel
import io.reactivex.Single
import javax.inject.Inject

class ForecastStubRepository @Inject constructor() : ForecastRepository {

    override fun getAllForecast(): Single<List<ForecastModel>> = Single.fromCallable {
        listOf(
            ForecastStubModel(ForecastType.TYPE_EVENT_PROMOTION),
            ForecastStubModel(ForecastType.TYPE_EVENT_PAST),
            ForecastStubModel(ForecastType.TYPE_EVENT_EXPRESS)
        )
    }
}

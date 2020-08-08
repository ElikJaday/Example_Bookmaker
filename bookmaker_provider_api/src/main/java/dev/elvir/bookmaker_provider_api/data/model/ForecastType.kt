package dev.elvir.bookmaker_provider_api.data.model

enum class ForecastType(int: Int) {
    TYPE_EVENT_PROMOTION(0),
    TYPE_EVENT_PAST(1),
    TYPE_EVENT_EXPRESS(2)
}
package dev.elvir.bookmaker_provider_api.data.model

interface BookmakerRatingsModel {
    var bookmakerType: BookmakerType?
    var bookmakerBonus: String?
    var bookmakerBackgroundColor: Int?
    var bookmakerPercent: Double?
}
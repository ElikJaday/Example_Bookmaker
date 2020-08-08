package dev.elvir.bookmaker_provider_impl.data.model

import dev.elvir.bookmaker_provider_api.data.model.BookmakerRatingsModel
import dev.elvir.bookmaker_provider_api.data.model.BookmakerType

class BookmakerRatingsStubModel(
    override var bookmakerType: BookmakerType?,
    override var bookmakerBonus: String?,
    override var bookmakerBackgroundColor: Int?,
    override var bookmakerPercent: Double?
) : BookmakerRatingsModel {


}
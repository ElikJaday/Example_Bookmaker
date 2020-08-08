package dev.elvir.bookmaker_provider_api.data.repository

import dev.elvir.bookmaker_provider_api.data.model.BookmakerRatingsModel
import io.reactivex.Single

interface BookmakerRatingRepository {
    fun getAllBookmakersRating(): Single<List<BookmakerRatingsModel>>
}
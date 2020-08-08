package dev.elvir.bookmaker_provider_impl.data.repository

import dev.elvir.bookmaker_provider_api.data.model.BookmakerRatingsModel
import dev.elvir.bookmaker_provider_api.data.model.BookmakerType
import dev.elvir.bookmaker_provider_api.data.repository.BookmakerRatingRepository
import dev.elvir.bookmaker_provider_impl.data.model.BookmakerRatingsStubModel
import io.reactivex.Single
import javax.inject.Inject

class BookmakerRatingsStubRepository @Inject constructor() : BookmakerRatingRepository {

    override fun getAllBookmakersRating(): Single<List<BookmakerRatingsModel>> =
        Single.fromCallable {
            listOf(
                BookmakerRatingsStubModel(BookmakerType.BETCITY, "1 000", null, 5.4),
                BookmakerRatingsStubModel(BookmakerType.PARIMATCH, "2 000", null, 1.4),
                BookmakerRatingsStubModel(BookmakerType.STAVKA, "3 000", null, 2.4),
                BookmakerRatingsStubModel(BookmakerType.WINLINE, "4 000", null, 2.4)
            )
        }
}
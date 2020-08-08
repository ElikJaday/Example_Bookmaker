package dev.elvir.bookmaker_provider_impl.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.elvir.bookmaker_provider_api.data.model.BookmakerType
import dev.elvir.bookmaker_provider_api.data.repository.BookmakerRatingRepository
import dev.elvir.bookmaker_provider_impl.data.model.BookmakerRatingsStubModel
import dev.elvir.bookmaker_provider_impl.data.repository.BookmakerRatingsStubRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import java.lang.RuntimeException


class BookmakerRepositoryTest {

    private lateinit var repository: BookmakerRatingRepository

    @Before
    fun setUp() {
        repository = mock()
    }

    @Test
    fun bookmaker_repository_response_success() {
        //mock
        whenever(repository.getAllBookmakersRating()).thenReturn(
            Single.just(
                listOf(
                    BookmakerRatingsStubModel(BookmakerType.PARIMATCH,"",null,null)
                )
            )
        )
        //action
       var testRx =  repository.getAllBookmakersRating().test()

        //verify
        testRx.assertComplete()
        testRx.assertValue { it.size==1 }
    }

    @Test
    fun bookmaker_repository_response_error() {
        //mock
        whenever(repository.getAllBookmakersRating()).thenReturn(
            Single.error(
              RuntimeException("undefined")
            )
        )
        //action
        var testRx =  repository.getAllBookmakersRating().test()

        //verify
        testRx.onError(RuntimeException())
    }


}


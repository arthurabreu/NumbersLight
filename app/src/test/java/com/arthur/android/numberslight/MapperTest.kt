package com.arthur.android.numberslight

import com.arthur.android.numberslight.listnumbers.NumbersListRepositoryMapper
import com.arthur.android.numberslight.listnumbers.model.Numbers
import com.arthur.android.numberslight.network.NetworkInterface
import com.arthur.android.numberslight.network.model.NLEntity
import com.arthur.android.numberslight.network.model.NumberDetailsEntity
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.amshove.kluent.`should equal`
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Test

class MapperTest {

    var networkClient: NetworkInterface = mock {
        on { getNumbersEntity() } doReturn getNumbersObservable()
        on { getNumberDetails(1) } doReturn getNumberDetailsEntityObservable()
    }

    val nlEntity: List<Numbers> = getNumbers()
    var mapper = NumbersListRepositoryMapper(networkClient)

    @Test
    fun `map from entity`() {
        mapper.getNumbers().blockingGet() `should equal` nlEntity
    }

    private fun getNumbersObservable(): Single<List<NLEntity>> {
        return Single.just(getNLEntity())
    }

    private fun getNumberDetailsEntityObservable(): Observable<NumberDetailsEntity> {
        return Observable.just(getNumberDetailsEntity())
    }
}
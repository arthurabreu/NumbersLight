package com.arthur.android.numberslight.details

import com.arthur.android.numberslight.details.model.NumberDetails
import com.arthur.android.numberslight.network.NetworkInterface
import com.arthur.android.numberslight.network.model.NumberDetailsEntity
import io.reactivex.Observable

class NumberDetailsRepositoryMapper (private val networkClient: NetworkInterface) {
    fun getNumberDetails(id: Int): Observable<NumberDetails> =
            networkClient.getNumberDetails(id)
                    .map {
                        it.toModel()
                    }

    private fun NumberDetailsEntity.toModel() = NumberDetails(
            this.name, this.text, this.image.replaceURL()
    )

    private fun String.replaceURL() = replace("http://","https://")
}
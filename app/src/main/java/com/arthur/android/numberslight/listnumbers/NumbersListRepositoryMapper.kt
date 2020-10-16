package com.arthur.android.numberslight.listnumbers

import com.arthur.android.numberslight.listnumbers.model.Numbers
import com.arthur.android.numberslight.network.NetworkInterface
import com.arthur.android.numberslight.network.model.NLEntity
import io.reactivex.Single

class NumbersListRepositoryMapper(private val networkClient: NetworkInterface) {

    fun getNumbers(): Single<List<Numbers>> = networkClient.getNumbersEntity().map { it ->
        it.map {
            it.toModel()
        }
    }
    private fun NLEntity.toModel() = Numbers(this.name, this.image)
}
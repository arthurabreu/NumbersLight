package com.arthur.android.numberslight.network

import com.arthur.android.numberslight.network.model.NLEntity
import com.arthur.android.numberslight.network.model.NumberDetailsEntity
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkInterface {
    @GET("json.php")
    fun getNumbersEntity(): Single<List<NLEntity>>

    @GET("json.php?")
    fun getNumberDetails(@Query("name") name : Int): Observable<NumberDetailsEntity>
}
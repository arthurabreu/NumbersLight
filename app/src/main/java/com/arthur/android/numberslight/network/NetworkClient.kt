package com.arthur.android.numberslight.network

import android.content.Context
import com.arthur.android.numberslight.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient(context: Context) {

    var networkResponse: NetworkInterface = create(context)

    private fun create(context: Context): NetworkInterface {

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(getClient(context))
                .build()
        return retrofit.create(NetworkInterface::class.java)
    }

    private fun getClient(context: Context): OkHttpClient {
        return OkHttpClient().newBuilder()
                .addInterceptor(NoConnectionInterceptor(context)).build()
    }
}
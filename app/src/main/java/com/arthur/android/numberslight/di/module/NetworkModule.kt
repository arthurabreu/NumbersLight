package com.arthur.android.numberslight.di.module

import android.content.Context
import com.arthur.android.numberslight.network.NetworkClient
import com.arthur.android.numberslight.network.NetworkInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideApiService(context: Context): NetworkInterface {
        return NetworkClient(context).networkResponse
    }
}
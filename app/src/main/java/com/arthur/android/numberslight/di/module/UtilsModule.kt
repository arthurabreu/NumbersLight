package com.arthur.android.numberslight.di.module

import android.content.Context
import com.arthur.android.numberslight.network.CustomScheduler
import com.arthur.android.numberslight.utils.ErrorHandler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Singleton
    @Provides
    fun provideCustomScheduler(): CustomScheduler {
        return CustomScheduler()
    }

    @Singleton
    @Provides
    fun provideRepo(context: Context): ErrorHandler {
        return ErrorHandler(context)
    }
}
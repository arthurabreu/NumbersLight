package com.arthur.android.numberslight.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class NumberLightApplicationModule(private val context: Context) {

    @Provides
    fun provideApplication(): Context {
        return context
    }
}
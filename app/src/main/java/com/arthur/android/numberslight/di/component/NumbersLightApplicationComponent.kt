package com.arthur.android.numberslight.di.component

import com.arthur.android.numberslight.MainApplication
import com.arthur.android.numberslight.activity.binder.NumbersActivityBinder
import com.arthur.android.numberslight.details.di.binder.NumbersDetailFragmentBinder
import com.arthur.android.numberslight.details.di.module.NumberDetailFragmentModule
import com.arthur.android.numberslight.details.di.module.NumberDetailRepoModule
import com.arthur.android.numberslight.di.module.NetworkModule
import com.arthur.android.numberslight.di.module.NumberLightApplicationModule
import com.arthur.android.numberslight.di.module.UtilsModule
import com.arthur.android.numberslight.listnumbers.di.binder.ListNumbersFragmentBinder
import com.arthur.android.numberslight.listnumbers.di.module.NumbersListFragmentModule
import com.arthur.android.numberslight.listnumbers.di.module.NumbersListRepoModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            NumberLightApplicationModule::class,
            NumbersActivityBinder::class,
            ListNumbersFragmentBinder::class,
            NumbersListFragmentModule::class,
            NumbersListRepoModule::class,
            NumbersDetailFragmentBinder::class,
            NumberDetailFragmentModule::class,
            NumberDetailRepoModule::class,
            NetworkModule::class,
            UtilsModule::class
        ]
)

interface NumbersLightApplicationComponent {
    fun inject(application: MainApplication)
}
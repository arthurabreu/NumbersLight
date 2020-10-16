package com.arthur.android.numberslight

import android.app.Activity
import android.app.Application
import com.arthur.android.numberslight.di.component.DaggerNumbersLightApplicationComponent
import com.arthur.android.numberslight.di.component.NumbersLightApplicationComponent
import com.arthur.android.numberslight.di.module.NumberLightApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MainApplication: Application(), HasActivityInjector {

    lateinit var component: NumbersLightApplicationComponent

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup() {
        component = DaggerNumbersLightApplicationComponent
                .builder()
                .numberLightApplicationModule(NumberLightApplicationModule(this))
                .build()
        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}
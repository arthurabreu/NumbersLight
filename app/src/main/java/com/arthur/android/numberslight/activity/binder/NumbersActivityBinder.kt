package com.arthur.android.numberslight.activity.binder

import com.arthur.android.numberslight.activity.MainActivity
import com.arthur.android.numberslight.activity.di.NumbersActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [NumbersActivityComponent::class])
internal abstract class NumbersActivityBinder {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindYourActivityInjectorFactory(builder: NumbersActivityComponent.Builder):
            AndroidInjector.Factory<*>
}
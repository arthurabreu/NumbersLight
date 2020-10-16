package com.arthur.android.numberslight.details.di.binder

import com.arthur.android.numberslight.details.NumberDetailFragment
import com.arthur.android.numberslight.details.di.component.NumberDetailFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [NumberDetailFragmentComponent::class])
internal abstract class NumbersDetailFragmentBinder {

    @Binds
    @IntoMap
    @ClassKey(NumberDetailFragment::class)
    internal abstract fun bindYourAFragmentInjectorFactory(builder: NumberDetailFragmentComponent.Builder):
            AndroidInjector.Factory<*>
}
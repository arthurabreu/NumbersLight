package com.arthur.android.numberslight.listnumbers.di.binder

import com.arthur.android.numberslight.listnumbers.NumbersListFragment
import com.arthur.android.numberslight.listnumbers.di.component.NumbersListFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [NumbersListFragmentComponent::class])
internal abstract class ListNumbersFragmentBinder {

    @Binds
    @IntoMap
    @ClassKey(NumbersListFragment::class)
    internal abstract fun bindNumbersListFragmentInjectorFactory(builder: NumbersListFragmentComponent.Builder):
            AndroidInjector.Factory<*>
}
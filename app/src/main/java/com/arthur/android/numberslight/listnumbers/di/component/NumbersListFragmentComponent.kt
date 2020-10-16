package com.arthur.android.numberslight.listnumbers.di.component

import com.arthur.android.numberslight.di.scopes.FragmentScope
import com.arthur.android.numberslight.listnumbers.NumbersListFragment
import com.arthur.android.numberslight.listnumbers.di.module.NumbersListFragmentModule
import com.arthur.android.numberslight.listnumbers.di.module.NumbersListRepoModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(
        modules = [NumbersListFragmentModule::class, NumbersListRepoModule::class]
)
interface NumbersListFragmentComponent : AndroidInjector<NumbersListFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NumbersListFragment>()
}
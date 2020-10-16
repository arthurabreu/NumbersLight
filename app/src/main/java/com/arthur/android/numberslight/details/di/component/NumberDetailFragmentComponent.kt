package com.arthur.android.numberslight.details.di.component

import com.arthur.android.numberslight.details.NumberDetailFragment
import com.arthur.android.numberslight.details.di.module.NumberDetailFragmentModule
import com.arthur.android.numberslight.details.di.module.NumberDetailRepoModule
import com.arthur.android.numberslight.di.scopes.FragmentScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(
        modules = [NumberDetailFragmentModule::class, NumberDetailRepoModule::class]
)
interface NumberDetailFragmentComponent : AndroidInjector<NumberDetailFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NumberDetailFragment>()
}
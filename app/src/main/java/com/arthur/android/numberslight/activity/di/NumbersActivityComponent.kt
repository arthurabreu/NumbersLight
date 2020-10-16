package com.arthur.android.numberslight.activity.di

import com.arthur.android.numberslight.activity.MainActivity
import com.arthur.android.numberslight.activity.module.ActivityModule
import com.arthur.android.numberslight.di.scopes.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface NumbersActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
package com.arthur.android.numberslight.listnumbers.di.module

import com.arthur.android.numberslight.di.scopes.FragmentScope
import com.arthur.android.numberslight.listnumbers.NumbersListRepositoryMapper
import com.arthur.android.numberslight.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class NumbersListRepoModule{
    @FragmentScope
    @Provides
    fun provideRepo(networkInterface: NetworkInterface): NumbersListRepositoryMapper {
        return NumbersListRepositoryMapper(networkInterface)
    }
}
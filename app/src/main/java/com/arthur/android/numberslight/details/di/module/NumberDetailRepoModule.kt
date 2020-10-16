package com.arthur.android.numberslight.details.di.module

import com.arthur.android.numberslight.details.NumberDetailsRepositoryMapper
import com.arthur.android.numberslight.di.scopes.FragmentScope
import com.arthur.android.numberslight.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class NumberDetailRepoModule {

    @FragmentScope
    @Provides
    fun provideDetailRepo(networkInterface: NetworkInterface): NumberDetailsRepositoryMapper {
        return NumberDetailsRepositoryMapper(networkInterface)
    }
}
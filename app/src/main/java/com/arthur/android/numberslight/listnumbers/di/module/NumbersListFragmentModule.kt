package com.arthur.android.numberslight.listnumbers.di.module

import androidx.lifecycle.ViewModelProviders
import com.arthur.android.numberslight.di.scopes.FragmentScope
import com.arthur.android.numberslight.listnumbers.NumbersListFragment
import com.arthur.android.numberslight.listnumbers.NumbersListRepositoryMapper
import com.arthur.android.numberslight.listnumbers.NumbersListViewModel
import com.arthur.android.numberslight.listnumbers.di.factory.NumbersListProviderFactory
import com.arthur.android.numberslight.network.CustomScheduler
import com.arthur.android.numberslight.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class NumbersListFragmentModule {

    @FragmentScope
    @Provides
    fun providesNumbersListViewModelFactory(
            repo: NumbersListRepositoryMapper,
            customScheduler: CustomScheduler,
            errorHandler: ErrorHandler
    ): NumbersListProviderFactory {
        return NumbersListProviderFactory(
                repo,
                customScheduler,
                errorHandler
        )
    }

    @FragmentScope
    @Provides
    fun providesNumbersListViewModel(
            fragment: NumbersListFragment,
            factory: NumbersListProviderFactory
    ): NumbersListViewModel {
        return ViewModelProviders.of(fragment, factory).get(NumbersListViewModel::class.java)
    }
}
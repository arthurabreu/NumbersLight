package com.arthur.android.numberslight.details.di.module

import androidx.lifecycle.ViewModelProviders
import com.arthur.android.numberslight.details.NumberDetailFragment
import com.arthur.android.numberslight.details.NumberDetailsRepositoryMapper
import com.arthur.android.numberslight.details.NumberDetailsViewModel
import com.arthur.android.numberslight.details.di.factory.NumberDetailProviderFactory
import com.arthur.android.numberslight.di.scopes.FragmentScope
import com.arthur.android.numberslight.network.CustomScheduler
import com.arthur.android.numberslight.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class NumberDetailFragmentModule {

    @FragmentScope
    @Provides
    fun providesNumbersDetailViewModelFactory(
            repo: NumberDetailsRepositoryMapper,
            customScheduler: CustomScheduler,
            errorHandler: ErrorHandler
    ): NumberDetailProviderFactory {
        return NumberDetailProviderFactory(
                repo,
                customScheduler,
                errorHandler
        )
    }

    @FragmentScope
    @Provides
    fun providesNumbersDetailViewModel(
            fragment: NumberDetailFragment,
            factory: NumberDetailProviderFactory
    ): NumberDetailsViewModel {
        return ViewModelProviders.of(fragment, factory).get(NumberDetailsViewModel::class.java)
    }
}
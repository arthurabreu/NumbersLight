package com.arthur.android.numberslight.details.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arthur.android.numberslight.details.NumberDetailsRepositoryMapper
import com.arthur.android.numberslight.details.NumberDetailsViewModel
import com.arthur.android.numberslight.network.CustomScheduler
import com.arthur.android.numberslight.utils.ErrorHandler

class NumberDetailProviderFactory(
        private val repo: NumberDetailsRepositoryMapper,
        private val customScheduler: CustomScheduler,
        private val errorHandler: ErrorHandler
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NumberDetailsViewModel(repo, customScheduler, errorHandler) as T
    }
}
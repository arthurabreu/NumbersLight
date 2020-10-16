package com.arthur.android.numberslight.listnumbers.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arthur.android.numberslight.listnumbers.NumbersListRepositoryMapper
import com.arthur.android.numberslight.listnumbers.NumbersListViewModel
import com.arthur.android.numberslight.network.CustomScheduler
import com.arthur.android.numberslight.utils.ErrorHandler

class NumbersListProviderFactory(
        private val repo: NumbersListRepositoryMapper,
        private val customScheduler: CustomScheduler,
        private val errorHandler: ErrorHandler
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NumbersListViewModel(repo, customScheduler, errorHandler) as T
    }
}
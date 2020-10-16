package com.arthur.android.numberslight.listnumbers

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.arthur.android.numberslight.listnumbers.model.Numbers
import com.arthur.android.numberslight.network.CustomScheduler
import com.arthur.android.numberslight.network.NoConnectionInterceptor
import com.arthur.android.numberslight.network.NoConnectionInterceptor.NoConnectivityException
import com.arthur.android.numberslight.utils.ErrorHandler
import com.arthur.android.numberslight.utils.Logger
import com.arthur.android.numberslight.utils.NUMBERS_LIGHT
import com.arthur.android.numberslight.utils.NUMBERS_LIGHT_ERROR
import com.arthur.android.numberslight.utils.mvvm.RxViewModel

class NumbersListViewModel (
        private val repo: NumbersListRepositoryMapper,
        private val customScheduler: CustomScheduler,
        private val errorHandler: ErrorHandler
) : RxViewModel(), LifecycleObserver {
    
    val resultsList: MutableLiveData<List<Numbers>> = MutableLiveData()
    val networkState: MutableLiveData<Boolean> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getNumbersResponse()
    }

    fun getNumbersResponse() {

        launch {
            repo.getNumbers()
                    .subscribeOn(customScheduler.io())
                    .observeOn(customScheduler.ui())
                    .subscribe({
                        networkState.postValue(true)
                        Logger.d(NUMBERS_LIGHT, it.toString())
                        resultsList.value = it
                    }, { error ->
                        error.message?.let {
                            Logger.e(NUMBERS_LIGHT_ERROR, it)
                            errorHandler.showError(it)
                            if(error == NoConnectivityException ||
                                    error == NoConnectionInterceptor.NoInternetException){
                                networkState.postValue(false)
                            }
                        }
                    })
        }
    }
}
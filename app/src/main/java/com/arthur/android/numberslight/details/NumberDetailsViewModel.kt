package com.arthur.android.numberslight.details

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.arthur.android.numberslight.details.model.NumberDetails
import com.arthur.android.numberslight.network.CustomScheduler
import com.arthur.android.numberslight.utils.ErrorHandler
import com.arthur.android.numberslight.utils.Logger
import com.arthur.android.numberslight.utils.NUMBERS_DETAIL
import com.arthur.android.numberslight.utils.NUMBERS_LIGHT_ERROR
import com.arthur.android.numberslight.utils.mvvm.RxViewModel

class NumberDetailsViewModel (
        private val repo: NumberDetailsRepositoryMapper,
        private val customScheduler: CustomScheduler,
        private val errorHandler: ErrorHandler
) : RxViewModel(), LifecycleObserver {

    val number = MutableLiveData<NumberDetails>()
    val numberId = MutableLiveData<Int>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        numberId.observeForever {
            it?.let { numberId ->
                getNumberDetails(numberId)
            }
        }
    }

    private fun getNumberDetails(id: Int) {

        launch {
            repo.getNumberDetails(id)
                    .subscribeOn(customScheduler.io())
                    .observeOn(customScheduler.ui())
                    .subscribe({
                        number.value = it
                        Logger.d(NUMBERS_DETAIL, it.toString())
                    }, { error ->
                        error.message?.let {
                            Logger.e(NUMBERS_LIGHT_ERROR, it)
                            errorHandler.showError(it)
                        }
                    })
        }
    }
}
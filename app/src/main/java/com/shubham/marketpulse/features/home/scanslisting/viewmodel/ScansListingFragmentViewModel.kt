package com.shubham.marketpulse.features.home.scanslisting.viewmodel

import androidx.lifecycle.*
import com.shubham.marketpulse.base.ViewModelRepositoryCommunicator
import com.shubham.marketpulse.features.home.scanslisting.repository.ScansListingRepository
import com.shubham.marketpulse.model.ScansData
import com.shubham.marketpulse.utility.Constants
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class ScansListingFragmentViewModel @Inject constructor(
    private val repository: ScansListingRepository
) : ViewModel(), ViewModelRepositoryCommunicator {

    /* Callbacks */

    private val errorLiveData = MutableLiveData<String>()
//    private val networkErrorLiveData = MutableLiveData<Boolean>()

    fun observeError(): LiveData<String> = errorLiveData

    override fun onError(errorMessage: String) {
        errorLiveData.postValue(errorMessage)
    }

    override fun onNetworkError(status: Boolean) {
        errorLiveData.postValue(Constants.NETWORK_ERROR_MESSAGE)
//        networkErrorLiveData.postValue(status)
    }

    /* BG tasks */

    fun fetchScansData(): LiveData<List<ScansData>?> {
        return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(repository.fetchScansData(this@ScansListingFragmentViewModel))
        }
    }

    /* Calculations */

    fun getScanAndCriteriaDetails(id: Int) = repository.getScanAndCriteriaDetails(id)
}
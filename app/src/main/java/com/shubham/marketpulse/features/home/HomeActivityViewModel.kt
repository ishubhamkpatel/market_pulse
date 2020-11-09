package com.shubham.marketpulse.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.shubham.marketpulse.model.CriteriaData
import com.shubham.marketpulse.model.ScansData
import javax.inject.Inject

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class HomeActivityViewModel @Inject constructor(): ViewModel() {

    /* LiveData */

    private val navigationLiveData = MutableLiveData<NavDirections>()
    private val shimmerLiveData = MutableLiveData<Boolean>()

    fun observeNavigation(): LiveData<NavDirections> = navigationLiveData

    fun yieldNavigation(directions: NavDirections) {
        navigationLiveData.value = directions
    }

    fun observeShimmerStatus(): LiveData<Boolean> = shimmerLiveData

    fun yieldShimmer(status: Boolean) {
        shimmerLiveData.value = status
    }

    /* Other properties */

    private var scan: ScansData? = null
    private var criteria = mutableListOf<CriteriaData>()

    fun getScanDetails() = scan

    fun setScanDetails(data: ScansData) {
        scan = data
    }

    fun getCriteriaDetails(): List<CriteriaData> = criteria

    fun setCriteriaDetails(data: List<CriteriaData>) {
        criteria.apply {
            clear()
            addAll(data)
        }
    }
}
package com.shubham.marketpulse.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import javax.inject.Inject

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class HomeActivityViewModel @Inject constructor(): ViewModel() {

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
}
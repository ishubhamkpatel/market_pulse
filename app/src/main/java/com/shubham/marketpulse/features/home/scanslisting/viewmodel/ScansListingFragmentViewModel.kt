package com.shubham.marketpulse.features.home.scanslisting.viewmodel

import androidx.lifecycle.ViewModel
import com.shubham.marketpulse.features.home.scanslisting.repository.ScansListingRepository
import javax.inject.Inject

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class ScansListingFragmentViewModel @Inject constructor(
    private val repository: ScansListingRepository
) : ViewModel() {
}
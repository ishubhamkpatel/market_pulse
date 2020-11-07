package com.shubham.marketpulse.features.home.scancriteria.viewmodel

import androidx.lifecycle.ViewModel
import com.shubham.marketpulse.features.home.scancriteria.repository.ScanCriteriaRepository
import javax.inject.Inject

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class ScanCriteriaFragmentViewModel @Inject constructor(
    private val repository: ScanCriteriaRepository
) : ViewModel() {
}
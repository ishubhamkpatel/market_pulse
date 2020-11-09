package com.shubham.marketpulse.base

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
interface ViewModelRepositoryCommunicator {

    fun onError(errorMessage: String)

    fun onNetworkError(status: Boolean)
}
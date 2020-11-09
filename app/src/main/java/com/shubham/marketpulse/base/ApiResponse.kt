package com.shubham.marketpulse.base

import retrofit2.Response
import java.net.UnknownHostException

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class ApiResponse<T> {
    var body: T?
    var throwable: Throwable?
    var code: Int = 0
    var errorMessage: String? = null
    var noInternet: Boolean? = null
    var isApiCallSuccessful: Boolean = true

    constructor(response: Response<T>) {
        code = response.code()
        if (response.isSuccessful) {
            body = response.body()
        } else {
            isApiCallSuccessful = false
            var message: String? = null
            response.errorBody()?.let {
                message = it.string()
            }
            if (message.isNullOrEmpty()) {
                message = response.message()
            }
            errorMessage = message
            body = null
        }
        throwable = null
    }

    constructor(error: Throwable) {
        body = null
        throwable = error
        errorMessage = error.message
        isApiCallSuccessful = false
    }

    constructor(e: UnknownHostException) {
        body = null
        throwable = null
        errorMessage = e.message
        noInternet = true
        isApiCallSuccessful = false
    }
}
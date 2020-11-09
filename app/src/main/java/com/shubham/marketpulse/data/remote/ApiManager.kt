package com.shubham.marketpulse.data.remote

import com.shubham.marketpulse.base.ApiResponse
import com.shubham.marketpulse.model.*
import java.net.UnknownHostException

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
class ApiManager(private val api: Api) : ApiHelper {

    override suspend fun fetchScansData(): ApiResponse<ScansDataResponse>? {
        return try {
            val apiResponse = api.fetchScansData()
            ApiResponse(apiResponse)
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                ApiResponse(e)
            } else {
                null
            }
        } catch (t: Throwable) {
            ApiResponse(t)
        }
    }
}
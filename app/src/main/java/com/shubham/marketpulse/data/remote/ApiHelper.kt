package com.shubham.marketpulse.data.remote

import com.shubham.marketpulse.base.ApiResponse
import com.shubham.marketpulse.model.*

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
interface ApiHelper {

    suspend fun fetchScansData(): ApiResponse<ScansDataResponse>?
}
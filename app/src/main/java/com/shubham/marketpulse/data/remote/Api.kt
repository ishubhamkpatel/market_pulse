package com.shubham.marketpulse.data.remote

import com.shubham.marketpulse.model.*
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
interface Api {

    companion object {
        private const val SCANS_DATA = "/data"
    }

    @GET(SCANS_DATA)
    suspend fun fetchScansData(): Response<ScansDataResponse>
}
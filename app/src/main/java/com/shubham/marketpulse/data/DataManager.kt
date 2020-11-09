package com.shubham.marketpulse.data

import com.shubham.marketpulse.data.local.DbHelper
import com.shubham.marketpulse.data.remote.ApiHelper

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
class DataManager(private val apiHelper: ApiHelper, private val dbHelper: DbHelper) : DataHelper {

    override suspend fun fetchScansData() = apiHelper.fetchScansData()
}
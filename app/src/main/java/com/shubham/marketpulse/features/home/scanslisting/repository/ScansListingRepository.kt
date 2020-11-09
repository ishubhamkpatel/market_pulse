package com.shubham.marketpulse.features.home.scanslisting.repository

import com.shubham.marketpulse.base.ViewModelRepositoryCommunicator
import com.shubham.marketpulse.data.DataHelper
import com.shubham.marketpulse.features.home.scancriteria.ScanCriteriaRecyclerAdapter
import com.shubham.marketpulse.model.CriteriaData
import com.shubham.marketpulse.model.ScansData
import com.shubham.marketpulse.model.ScansDataResponse
import com.shubham.marketpulse.utility.Constants
import java.util.*
import javax.inject.Inject

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
class ScansListingRepository @Inject constructor(private val dataHelper: DataHelper) {

    private var scansData: ScansDataResponse? = null

    /* Network call */

    suspend fun fetchScansData(communicator: ViewModelRepositoryCommunicator): List<ScansData>? {
        val response = dataHelper.fetchScansData()
        var result: List<ScansData>? = null
        response?.let { apiResponse ->
            when {
                apiResponse.isApiCallSuccessful -> {
                    scansData = apiResponse.body
                    result = formatScansData(scansData)
                }
                (apiResponse.noInternet == true) -> {
                    communicator.onNetworkError(true)
                }
                else -> {
                    communicator.onError(Constants.GENERIC_ERROR_MESSAGE)
                }
            }
        }
        return result
    }

    private fun formatScansData(scansData: ScansDataResponse?): List<ScansData> {
        val data = mutableListOf<ScansData>()
        scansData?.forEach { item ->
            data += ScansData(
                scanId = item.id,
                scanTitle = item.name,
                scanSubtitle = item.tag,
                colorCode = checkColor(item.color)
            )
        }
        return data
    }

    private fun checkColor(color: String?): String {
        return when (color?.toLowerCase(Locale.ENGLISH)) {
            "green" -> "#78F078"
            "red" -> "#F74545"
            "blue" -> "#4C4CFC"
            else -> "#FFFFFF"
        }
    }

    fun getScanAndCriteriaDetails(id: Int): Pair<ScansData?, List<CriteriaData>?> {
        val scanItem = scansData?.find { it.id == id }
        val scanDetails = scanItem?.let {
            ScansData(scanId = id, scanTitle = it.name, scanSubtitle = it.tag, colorCode = checkColor(it.color))
        }
        val criteriaDetails = scanItem?.criteria?.let { formatScan(it) }
        return Pair(scanDetails, criteriaDetails)
    }

    private fun formatScan(criteriaList: List<ScansDataResponse.ScansDataResponseItem.Criteria?>): List<CriteriaData> {
        val data = mutableListOf<CriteriaData>()
        criteriaList.forEachIndexed { index, criteria ->
            data += CriteriaData(viewType = ScanCriteriaRecyclerAdapter.TYPE_DETAILS, text = criteria?.text)
            if (index != criteriaList.lastIndex) {
                data += CriteriaData(viewType = ScanCriteriaRecyclerAdapter.TYPE_JOIN)
            }
        }
        return data
    }
}
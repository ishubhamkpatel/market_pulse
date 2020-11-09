package com.shubham.marketpulse.model

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
data class ScansData(
    val scanId: Int?,
    val scanTitle: String?,
    val scanSubtitle: String?,
    val colorCode: String?
)

data class CriteriaData(
    val viewType: Int?,
    val text: String?
)
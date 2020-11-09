package com.shubham.marketpulse.model

import com.google.gson.annotations.SerializedName

class ScansDataResponse : ArrayList<ScansDataResponse.ScansDataResponseItem>() {
    data class ScansDataResponseItem(
      @SerializedName("color")
      val color: String?,
      @SerializedName("criteria")
      val criteria: List<Criteria?>?,
      @SerializedName("id")
      val id: Int?,
      @SerializedName("name")
      val name: String?,
      @SerializedName("tag")
      val tag: String?
    ) {
        data class Criteria(
          @SerializedName("text")
          val text: String?,
          @SerializedName("type")
          val type: String?,
          @SerializedName("variable")
          val variable: Variable?
        ) {
            data class Variable(
              @SerializedName("$1")
              val x1: X1?,
              @SerializedName("$2")
              val x2: X2?,
              @SerializedName("$3")
              val x3: X3?,
              @SerializedName("$4")
              val x4: X4?
            ) {
                data class X1(
                  @SerializedName("default_value")
                  val defaultValue: Int?,
                  @SerializedName("max_value")
                  val maxValue: Int?,
                  @SerializedName("min_value")
                  val minValue: Int?,
                  @SerializedName("parameter_name")
                  val parameterName: String?,
                  @SerializedName("study_type")
                  val studyType: String?,
                  @SerializedName("type")
                  val type: String?,
                  @SerializedName("values")
                  val values: List<Double?>?
                )

                data class X2(
                  @SerializedName("default_value")
                  val defaultValue: Int?,
                  @SerializedName("max_value")
                  val maxValue: Int?,
                  @SerializedName("min_value")
                  val minValue: Int?,
                  @SerializedName("parameter_name")
                  val parameterName: String?,
                  @SerializedName("study_type")
                  val studyType: String?,
                  @SerializedName("type")
                  val type: String?,
                  @SerializedName("values")
                  val values: List<Double?>?
                )

                data class X3(
                  @SerializedName("default_value")
                  val defaultValue: Int?,
                  @SerializedName("max_value")
                  val maxValue: Int?,
                  @SerializedName("min_value")
                  val minValue: Int?,
                  @SerializedName("parameter_name")
                  val parameterName: String?,
                  @SerializedName("study_type")
                  val studyType: String?,
                  @SerializedName("type")
                  val type: String?,
                  @SerializedName("values")
                  val values: List<Double?>?
                )

                data class X4(
                  @SerializedName("default_value")
                  val defaultValue: Int?,
                  @SerializedName("max_value")
                  val maxValue: Int?,
                  @SerializedName("min_value")
                  val minValue: Int?,
                  @SerializedName("parameter_name")
                  val parameterName: String?,
                  @SerializedName("study_type")
                  val studyType: String?,
                  @SerializedName("type")
                  val type: String?,
                  @SerializedName("values")
                  val values: List<Double?>?
                )
            }
        }
    }
}
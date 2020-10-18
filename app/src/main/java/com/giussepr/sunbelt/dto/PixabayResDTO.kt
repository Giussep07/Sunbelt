package com.giussepr.sunbelt.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PixabayResDTO(
    @Json(name = "total") val total: Int,
    @Json(name = "totalHits") val totalHits: Int,
    @Json(name = "hits") val hits: List<PixabayImageResDTO>,
)
package com.giussepr.sunbelt.webService

import com.giussepr.sunbelt.BuildConfig
import com.giussepr.sunbelt.dto.PixabayResDTO
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SunbeltApi {

    companion object {

    }

    @GET(".")
    suspend fun getPixabayImages(
        @Query("key") key: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("lang") language: String,
        @Query("image_type") imageType: String = "photo",
        @Query("orientation") orientation: String = "horizontal"
    ): Response<PixabayResDTO>
}
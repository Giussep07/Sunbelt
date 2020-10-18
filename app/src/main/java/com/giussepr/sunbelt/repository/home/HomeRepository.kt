package com.giussepr.sunbelt.repository.home

import com.giussepr.sunbelt.BuildConfig
import com.giussepr.sunbelt.dto.PixabayResDTO
import com.giussepr.sunbelt.ui.home.IContractHome
import com.giussepr.sunbelt.webService.SunbeltApi
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val sunbeltApi: SunbeltApi) :
    IContractHome.Repository {


    override suspend fun getImages(page: Int, perPage: Int, language: String): Response<PixabayResDTO> {
        return sunbeltApi.getPixabayImages(
            key = BuildConfig.PIXABAY_API_KEY,
            page = page,
            perPage = perPage,
            language = language
        )
    }
}
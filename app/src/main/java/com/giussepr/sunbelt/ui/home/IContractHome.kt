package com.giussepr.sunbelt.ui.home

import com.giussepr.sunbelt.dto.PixabayResDTO
import okhttp3.ResponseBody
import retrofit2.Response

interface IContractHome {

    interface ViewModel {
        fun getImages()
    }

    interface Repository {
        suspend fun getImages(page: Int, perPage: Int, language: String): Response<PixabayResDTO>
    }
}
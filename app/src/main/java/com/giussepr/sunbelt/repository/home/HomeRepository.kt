package com.giussepr.sunbelt.repository.home

import com.giussepr.sunbelt.ui.home.IContractHome
import com.giussepr.sunbelt.webService.SunbeltApi
import javax.inject.Inject

class HomeRepository @Inject constructor(private val sunbeltApi: SunbeltApi) :
    IContractHome.Repository {


    override suspend fun getImages() {

    }
}
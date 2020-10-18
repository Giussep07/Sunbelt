package com.giussepr.sunbelt.ui.home

interface IContractHome {

    interface ViewModel {
        fun getImages()
    }

    interface Repository {
        suspend fun getImages()
    }
}
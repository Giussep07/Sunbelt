package com.giussepr.sunbelt.ui.home

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: IContractHome.Repository) :
    ViewModel(), IContractHome.ViewModel {

    override fun getImages() {
    }
}
package com.giussepr.sunbelt.di.modules

import com.giussepr.sunbelt.repository.home.HomeRepository
import com.giussepr.sunbelt.ui.home.IContractHome
import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {

    @Binds
    abstract fun provideRepository(repository: HomeRepository): IContractHome.Repository
}
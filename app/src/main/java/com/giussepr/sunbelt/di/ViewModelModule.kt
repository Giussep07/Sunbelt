package com.giussepr.sunbelt.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.giussepr.sunbelt.ui.home.HomeViewModel
import com.giussepr.sunbelt.utility.viewModel.ViewModelFactory
import com.giussepr.sunbelt.utility.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}
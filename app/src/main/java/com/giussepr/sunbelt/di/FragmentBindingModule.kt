package com.giussepr.sunbelt.di

import com.giussepr.sunbelt.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment
}
package com.giussepr.sunbelt.di

import android.app.Application
import com.giussepr.sunbelt.app.SunbeltApp
import com.giussepr.sunbelt.di.modules.HomeModule
import com.giussepr.sunbelt.di.modules.NetworkModule
import com.giussepr.sunbelt.di.modules.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        FragmentBindingModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        HomeModule::class,
        RoomModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<SunbeltApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(application: Application): Builder

        fun build(): ApplicationComponent
    }

}
package com.giussepr.sunbelt.di.modules

import android.content.Context
import androidx.room.Room
import com.giussepr.sunbelt.db.SunbeltRoomDatabase
import com.giussepr.sunbelt.db.dao.PixabayImageDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    lateinit var sunbeltDB: SunbeltRoomDatabase

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): SunbeltRoomDatabase {
        sunbeltDB =
            Room.databaseBuilder(context, SunbeltRoomDatabase::class.java, "sunblet_database")
                .build()

        return sunbeltDB
    }

    @Provides
    @Singleton
    fun providePixabayImageDao(sunbeltRoomDatabase: SunbeltRoomDatabase): PixabayImageDao {
        return sunbeltRoomDatabase.pixabayImageDao()
    }
}
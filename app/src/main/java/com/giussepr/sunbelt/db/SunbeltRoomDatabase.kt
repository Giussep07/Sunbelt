package com.giussepr.sunbelt.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.giussepr.sunbelt.db.dao.PixabayImageDao
import com.giussepr.sunbelt.db.entity.PixabayImage

@Database(
    entities = [
        PixabayImage::class
    ],
    version = 1
)
abstract class SunbeltRoomDatabase : RoomDatabase() {

    abstract fun pixabayImageDao(): PixabayImageDao
}
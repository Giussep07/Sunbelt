package com.giussepr.sunbelt.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.giussepr.sunbelt.db.entity.PixabayImage

@Dao
interface PixabayImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPixabayImages(pixabayImage: List<PixabayImage>)
}
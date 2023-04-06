package com.emirk.app4.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.emirk.app4.StringListConverter
import com.emirk.app4.data.local.entity.Person

@Database(
    entities = [Person::class],
    version = 2
)
@TypeConverters(StringListConverter::class)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
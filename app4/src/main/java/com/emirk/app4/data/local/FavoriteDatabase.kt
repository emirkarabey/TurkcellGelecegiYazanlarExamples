package com.emirk.app4.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emirk.app4.data.local.entity.Person

@Database(
    entities = [Person::class],
    version = 1
)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
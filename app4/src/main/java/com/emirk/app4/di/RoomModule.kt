package com.emirk.app4.di

import android.content.Context
import androidx.room.Room
import com.emirk.app4.data.local.FavoriteDao
import com.emirk.app4.data.local.FavoriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val DATABASE_NAME = "person"
@[Module InstallIn(SingletonComponent::class)]
object StoreRoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): FavoriteDatabase{
        return Room.databaseBuilder(context, FavoriteDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(
        db:FavoriteDatabase
    ):FavoriteDao = db.favoriteDao()
}
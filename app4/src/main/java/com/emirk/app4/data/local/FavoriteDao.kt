package com.emirk.app4.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.emirk.app4.data.local.entity.Person

@Dao
interface FavoriteDao {
    @Insert
    suspend fun save(person: Person)

    @Query("DELETE FROM person WHERE uid=:id")
    suspend fun deletePerson(id: Int)

    @Query("SELECT * FROM person")
    fun getPerson(): Person
}
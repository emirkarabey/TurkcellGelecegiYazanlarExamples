package com.emirk.app4.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.emirk.app4.data.local.entity.Person

@Dao
interface FavoriteDao {
    @Insert
    suspend fun save(person: Person)

    @Query("DELETE FROM person WHERE name=:deleteName")
    suspend fun deletePerson(deleteName: String)

    @Query("SELECT * FROM person")
    fun getPerson(): Person
}
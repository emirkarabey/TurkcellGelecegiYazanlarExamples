package com.emirk.app4.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// to do map yada listeyi use case
@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "lastname") val lastname: String?,
    @ColumnInfo(name = "age") val age: String?,
    @ColumnInfo(name = "list") val list: List<String>?
)
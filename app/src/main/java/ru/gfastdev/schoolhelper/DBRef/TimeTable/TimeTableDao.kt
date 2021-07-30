package ru.gfastdev.schoolhelper.DBRef.TimeTable

import androidx.room.*

@Dao
interface TimeTableDao {

    @Query("SELECT * FROM timeTableDB ORDER BY :order")
    fun getAll(order: String): List<TimeTableEntity>

    @Insert
    fun insert(vararg entity: TimeTableEntity)

    @Delete
    fun delete (entity : TimeTableEntity)

    @Update
    fun update (vararg entity: TimeTableEntity)

}
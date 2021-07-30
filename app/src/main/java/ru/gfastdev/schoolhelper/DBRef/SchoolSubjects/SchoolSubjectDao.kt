package ru.gfastdev.schoolhelper.DBRef.SchoolSubjects

import androidx.room.*
import ru.gfastdev.schoolhelper.DBRef.TimeTable.TimeTableEntity

@Dao
interface SchoolSubjectDao {

    @Query("SELECT * FROM schoolSubjects ORDER BY name")
    fun getAll() : List<SchoolSubjectEntity>

    @Query("DELETE FROM schoolSubjects")
    fun deleteAll()

    @Insert
    fun insert(vararg entity: SchoolSubjectEntity)

    @Delete
    fun delete (entity : SchoolSubjectEntity)

    @Update
    fun update (vararg entity: SchoolSubjectEntity)
}
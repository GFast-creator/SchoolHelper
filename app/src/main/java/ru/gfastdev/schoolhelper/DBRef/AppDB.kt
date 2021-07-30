package ru.gfastdev.schoolhelper.DBRef

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.gfastdev.schoolhelper.DBRef.Notes.NoteDao
import ru.gfastdev.schoolhelper.DBRef.Notes.NoteEntity
import ru.gfastdev.schoolhelper.DBRef.SchoolSubjects.SchoolSubjectDao
import ru.gfastdev.schoolhelper.DBRef.SchoolSubjects.SchoolSubjectEntity
import ru.gfastdev.schoolhelper.DBRef.TimeTable.TimeTableDao
import ru.gfastdev.schoolhelper.DBRef.TimeTable.TimeTableEntity

@Database(entities = [TimeTableEntity::class, SchoolSubjectEntity::class, NoteEntity::class], version = 6)
abstract class AppDB : RoomDatabase() {

    abstract fun timeTableDao() : TimeTableDao

    abstract fun schoolSubjectDao() : SchoolSubjectDao

    abstract fun noteDao() : NoteDao

}
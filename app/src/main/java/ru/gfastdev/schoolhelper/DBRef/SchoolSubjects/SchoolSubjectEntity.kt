package ru.gfastdev.schoolhelper.DBRef.SchoolSubjects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schoolSubjects")
data class SchoolSubjectEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Int,

    @ColumnInfo(name = "name")
    var name : String
)
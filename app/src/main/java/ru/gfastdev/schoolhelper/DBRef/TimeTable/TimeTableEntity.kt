package ru.gfastdev.schoolhelper.DBRef.TimeTable

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.gfastdev.schoolhelper.SimpleClasses.SchoolSubject

@Entity(tableName = "timeTableDB")
data class TimeTableEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "listOfSubjects")
    var l:String //ArrayList<SchoolSubject>
)
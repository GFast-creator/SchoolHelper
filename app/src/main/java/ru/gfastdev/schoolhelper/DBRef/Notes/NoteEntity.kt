package ru.gfastdev.schoolhelper.DBRef.Notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteTable")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "date")
    var date:String,

    @ColumnInfo(name = "listOfObjects")
    var objects: String // Gson().fromJson() -- ArrayList<Any>

)

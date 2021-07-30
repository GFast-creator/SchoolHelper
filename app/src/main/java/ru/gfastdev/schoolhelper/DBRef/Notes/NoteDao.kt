package ru.gfastdev.schoolhelper.DBRef.Notes

import androidx.room.*
import ru.gfastdev.schoolhelper.DBRef.TimeTable.TimeTableEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteTable ORDER BY date")
    fun getAll():List<NoteEntity>

    @Ignore
    fun getMutableList() : MutableList<NoteEntity>{
        return getAll().toMutableList()
    }

    @Ignore
    fun getSize() : Int {
        return getAll().size
    }

    @Insert
    fun insert(vararg entity: NoteEntity)

    @Delete
    fun delete (entity : NoteEntity)

    @Update
    fun update (vararg entity: NoteEntity)

}
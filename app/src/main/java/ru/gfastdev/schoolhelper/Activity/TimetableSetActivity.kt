package ru.gfastdev.schoolhelper.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.google.gson.Gson
import ru.gfastdev.schoolhelper.Adapters.SchoolSubjectsAdapter
import ru.gfastdev.schoolhelper.DBRef.AppDB
import ru.gfastdev.schoolhelper.SimpleClasses.SchoolSubject
import ru.gfastdev.schoolhelper.databinding.ActivityTimetableSetBinding

class TimetableSetActivity : AppCompatActivity() {
    lateinit var builder:ActivityTimetableSetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var day = intent.getIntExtra("day",0)
        builder = ActivityTimetableSetBinding.inflate(layoutInflater)

        setContentView(builder.root)

        builder.buttonSave.setOnClickListener {
            //(it as Button).text = intent.getIntExtra("day",0).toString()
        }
        //JsonEditorClass(application).getListOfSubjects(day)

        val db by lazy {
            Room.databaseBuilder(
                this,
                AppDB::class.java,
                "timeTableDB.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        var array : ArrayList<SchoolSubject> = try {
            Gson().fromJson(db.timeTableDao().getAll("id = $day")[0].l, arrayListOf<SchoolSubject>()::class.java)

        //TODO: под БД
        } catch (e:Exception){
            arrayListOf()
        }



        val arrayAdapter = SchoolSubjectsAdapter(this, array)
        builder.ListView.adapter = arrayAdapter

        builder.addButton.setOnClickListener {
            array.add(SchoolSubject("", ""))
            arrayAdapter.notifyDataSetChanged()
            if (array.size <= 8) it.visibility = View.VISIBLE else it.visibility =
                View.INVISIBLE

        }
    }
}
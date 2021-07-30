package ru.gfastdev.schoolhelper.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import ru.gfastdev.schoolhelper.Adapters.SubjectsForFragmentAdapter
import ru.gfastdev.schoolhelper.DBRef.AppDB
import ru.gfastdev.schoolhelper.DBRef.SchoolSubjects.SchoolSubjectEntity

import ru.gfastdev.schoolhelper.databinding.FragmentSchoolSubjectsBinding

class SchoolSubjectsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var builder: FragmentSchoolSubjectsBinding
    lateinit var db: AppDB
    lateinit var n: MutableList<SchoolSubjectEntity>
    lateinit var adapter: SubjectsForFragmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        n = mutableListOf(SchoolSubjectEntity(0,"[загрузка...]"))
        adapter = SubjectsForFragmentAdapter(requireContext(), n)

        GlobalScope.launch {
            db = Room.databaseBuilder(requireContext(), AppDB::class.java, "timeTableDB.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

            n = db.schoolSubjectDao().getAll().toMutableList()

        }

        builder = FragmentSchoolSubjectsBinding.inflate(layoutInflater)

        builder.listOfSubjects.adapter = adapter

        builder.button.setOnClickListener {
            if (builder.editText.text.toString().trim().isNotEmpty()) {
                if (n.none { x -> x.name == builder.editText.text.toString() }) {
                    n.add(SchoolSubjectEntity(0, builder.editText.text.toString()))
                    builder.editText.text.clear()
                    n.sortBy { l ->
                        l.name
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    Snackbar.make(it, "Этот предмет уже существует", Snackbar.LENGTH_LONG).show()
                }
            } else {
                Snackbar.make(it, "Поле пустое", Snackbar.LENGTH_LONG).show()
            }
        }
        adapter.notifyDataSetChanged()
        return builder.root
    }

    /*fun initData(context: Context?){
        thread(start = true) {
            db = Room.databaseBuilder(requireContext(), AppDB::class.java, "timeTableDB.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

            n = db.schoolSubjectDao().getAll().toMutableList()

            adapter.notifyDataSetChanged()
        }
    }*/

    override fun onPause() {
        super.onPause()
        db.schoolSubjectDao().deleteAll()

        for (x in n) {
            db.schoolSubjectDao().insert(x)
        }

        db.close()
    }
}
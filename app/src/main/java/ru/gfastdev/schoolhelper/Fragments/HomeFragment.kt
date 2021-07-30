package ru.gfastdev.schoolhelper.Fragments

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.room.Room
import com.google.gson.Gson
import kotlinx.coroutines.*
import ru.gfastdev.schoolhelper.Adapters.NoteAdapter
import ru.gfastdev.schoolhelper.DBRef.AppDB
import ru.gfastdev.schoolhelper.DBRef.Notes.NoteEntity
import ru.gfastdev.schoolhelper.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var builder: FragmentHomeBinding
    lateinit var db : AppDB
    lateinit var data : MutableList<NoteEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        builder = FragmentHomeBinding.inflate(layoutInflater)
        data = mutableListOf(NoteEntity(0,"null", Gson().toJson(arrayListOf("loading..."))))

        val adapter = NoteAdapter(data)

        val x = runBlocking {
            launch {
                delay(5000)
                db = Room.databaseBuilder(requireContext(), AppDB::class.java, "noteTable")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                data = db.noteDao().getMutableList()
            }
        }
        
        builder.recyclerView.adapter = adapter
        builder.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        adapter.notifyDataSetChanged()
        return builder.root
    }

}
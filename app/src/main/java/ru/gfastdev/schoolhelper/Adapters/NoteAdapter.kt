package ru.gfastdev.schoolhelper.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import androidx.room.Room
import com.google.gson.Gson
import ru.gfastdev.schoolhelper.DBRef.AppDB
import ru.gfastdev.schoolhelper.DBRef.Notes.NoteEntity
import ru.gfastdev.schoolhelper.R

class NoteAdapter(var data : MutableList<NoteEntity>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.textView8)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note_recycler_view,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val data = Gson()
            .fromJson(
                data[position].objects,
                arrayListOf<Any>()::class.java
            )

        var s = ""

        data.forEach {
            if (it is String) s += it + "\n"
        }

        holder.textView.text = s
    }

    override fun getItemCount(): Int = data.size

}


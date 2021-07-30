package ru.gfastdev.schoolhelper.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import ru.gfastdev.schoolhelper.R
import ru.gfastdev.schoolhelper.SimpleClasses.SchoolSubject

class SchoolSubjectsAdapter(val context: Context, var list: ArrayList<SchoolSubject>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): SchoolSubject {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v = convertView
        if (v == null){
            //v = LayoutInflater.inflate(context, R.layout.item_subject,parent)
            v = LayoutInflater.from(context).inflate(R.layout.item_subject,parent,false)
            //TODO: хз что за говно
        }

        if (v != null) {
            v.findViewById<TextView>(R.id.textView2).text = list[position].name
            v.findViewById<TextView>(R.id.textView3).text = list[position].time
        }

        return v!!
    }

}
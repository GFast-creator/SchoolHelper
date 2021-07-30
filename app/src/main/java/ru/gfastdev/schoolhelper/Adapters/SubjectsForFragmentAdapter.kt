package ru.gfastdev.schoolhelper.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import ru.gfastdev.schoolhelper.DBRef.SchoolSubjects.SchoolSubjectEntity
import ru.gfastdev.schoolhelper.R

class SubjectsForFragmentAdapter(val context: Context, var data: MutableList<SchoolSubjectEntity>) : BaseAdapter() {
    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v = convertView
        if (v == null){
            v =  LayoutInflater.from(context).inflate(R.layout.item_subject_for_fragment,parent,false)
        }
        if (v != null) {
            v.findViewById<TextView>(R.id.nameOfSubject).text = data[position].name
            v.findViewById<Button>(R.id.deleteButton).setOnClickListener {
                data.removeAt(
                    data.indexOf(
                        data.filter {
                                x -> x.name == v.findViewById<TextView>(R.id.nameOfSubject).text.toString()
                        }[0]
                    )
                )

                this.notifyDataSetChanged()
            }
        }

        return v!!
    }
}
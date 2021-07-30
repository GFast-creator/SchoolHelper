package ru.gfastdev.schoolhelper.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.navigation.findNavController
import ru.gfastdev.schoolhelper.R
import ru.gfastdev.schoolhelper.databinding.FragmentTimetableBinding


class TimetableFragment : Fragment(), View.OnClickListener {

    private lateinit var builder: FragmentTimetableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        builder = FragmentTimetableBinding.inflate(layoutInflater)

        //Установка слушателей нажатий
        for (i in builder.root.children){
            Log.e("11", i.toString())
            i.setOnClickListener(this)
        }

        return builder.root
    }

    override fun onClick(v: View?) {
        if (v == null) return
        val bundle = Bundle()

        val day = builder.root.children.indexOf(v)+1

        bundle.putInt("day", day)

        v.findNavController().navigate(R.id.timetableSetActivity,bundle)
    }

}
package com.example.android_please.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.service.autofill.FillEventHistory
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import com.example.android_please.R
import com.example.android_please.adapters.ViewPagerAdapter
import com.example.android_please.adapters.todoGridAdapter
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment(context: Context) : Fragment() {
    var mCon = context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val RootView: View = inflater.inflate(R.layout.fragment_third, container, false)
        val btn = RootView.findViewById<Button>(R.id.bt_main)
        var adapter = todoGridAdapter(mCon)

        btn.setOnClickListener {
            val dialog = ToDoFragment(mCon, adapter)
            dialog.show(childFragmentManager, "todoDialog")
        }
        val gridView = RootView.findViewById<GridView>(R.id.gridView)
        gridView.adapter = adapter

        val ColorButton = RootView.findViewById<Button>(R.id.bt_color)

        ColorButton.setOnClickListener {
            ColorPickerDialog
                .Builder(requireActivity())
                .setTitle("color")
                .setColorShape(ColorShape.CIRCLE)
                .setDefaultColor(R.color.white)
                .setColorListener { color, colorHex ->
                    RootView.setBackgroundColor(Color.parseColor(colorHex))
                }.show()
        }
        return RootView
    }

}
package com.example.android_please.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.android_please.R
import com.example.android_please.adapters.MyCustomAdapter


class FirstFragment(context: Context) : Fragment() {

    var mCon = context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var RootView:View =  inflater.inflate(R.layout.fragment_first, container, false)

        val listView = RootView.findViewById<ListView>(R.id.main_listview)
        listView.adapter = MyCustomAdapter(mCon)
        return RootView
    }
}
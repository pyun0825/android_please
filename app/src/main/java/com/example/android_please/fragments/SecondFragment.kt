package com.example.android_please.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_please.R
import com.example.android_please.adapters.GridItemAdapter
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment(context: Context) : Fragment() {

    var mCon = context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var RootView:View = inflater.inflate(R.layout.fragment_second, container, false)

        val cardTitles: Array<String> = resources.getStringArray(R.array.cardTitles)
        val cardImages: Array<String> = resources.getStringArray(R.array.cardImages)

        val adapter = GridItemAdapter(cardTitles, cardImages)
        val gridLayout = GridLayoutManager(mCon, 2)
        val griditems = RootView.findViewById<RecyclerView>(R.id.griditems)
        griditems.layoutManager = gridLayout
        griditems.adapter = adapter

        return RootView
    }


}
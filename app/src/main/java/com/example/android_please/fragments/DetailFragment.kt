package com.example.android_please.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_please.R
import com.example.android_please.adapters.DetailLVAdaper
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail)
        val listView = findViewById<ListView>(R.id.lv_detail_todos)
        var date = intent.getStringExtra("date")
        tv_detail_date.text = date
        listView.adapter = DetailLVAdaper(date, this)
        bt_detail_back.setOnClickListener {
            finish()
        }
    }

}
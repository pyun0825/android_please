package com.example.android_please.fragments

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_please.R
import com.example.android_please.adapters.DetailLVAdaper
import com.example.android_please.adapters.DetailLinkAdapter
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : AppCompatActivity() {
    lateinit var LinkAdapter :DetailLinkAdapter

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
        val listView2 = findViewById<ListView>(R.id.lv_detail_links)
        LinkAdapter = DetailLinkAdapter(date, this)
        listView2.adapter = LinkAdapter
        bt_detail_add.setOnClickListener {
            var dialog = LinkDialogFragment(this, date, listView2.adapter as DetailLinkAdapter)
            dialog.show(supportFragmentManager, "LinkDialog")
        }
    }
}
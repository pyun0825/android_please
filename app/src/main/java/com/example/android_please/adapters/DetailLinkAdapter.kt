package com.example.android_please.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.example.android_please.R
import java.lang.Exception

class DetailLinkAdapter(date: String?, var context: Context):BaseAdapter() {
    var date = date
    var db = DataBaseHandler(context)
    var linkList = db.getLinks(date)

    override fun getCount(): Int {
        return linkList.size
    }

    override fun getItem(position: Int): Any {
        return "Test String"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val linkItem = LayoutInflater.from(parent?.context).inflate(R.layout.detail_link_item, parent, false)
        val tv_link = linkItem.findViewById<TextView>(R.id.tv_link)
        val deleteBtn = linkItem.findViewById<Button>(R.id.bt_detail_delete)

        tv_link.text = linkList[position].get(0) as String
        deleteBtn.setOnClickListener {
            val id = linkList[position].get(1) as Int
            db.deleteLink(id)
            val activity = context as Activity
            activity.recreate()
        }
        tv_link.setOnClickListener {
            try {
                var url = tv_link.text.toString()
                if(!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://"+url
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            } catch (e:Exception){
                System.out.println("Crash")
            }
        }
        return linkItem
    }
}
package com.example.android_please.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.android_please.R
import kotlinx.android.synthetic.main.to_do_card.view.*

class todoGridAdapter(var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        var db = DataBaseHandler(context)
        var dateList = db.dateList()
        System.out.println("size:"+dateList.size)
        return dateList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var todoView = inflater.inflate(R.layout.to_do_card, null)
        var db = DataBaseHandler(context)
        var dateList = db.dateList()
        todoView.tv_date.text = dateList[position].get(0).toString()
        todoView.tv_numtodo.text = "ToDos: "+dateList[position].get(1).toString()
        return todoView
    }
}
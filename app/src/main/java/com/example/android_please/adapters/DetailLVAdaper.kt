package com.example.android_please.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.android_please.R

class DetailLVAdaper(date: String?, var context: Context): BaseAdapter() {
    var date = date
    var db = DataBaseHandler(context)
    var todoList = db.todoList(date)


    override fun getCount(): Int {
        return todoList.size
    }

    override fun getItem(position: Int): Any {
        return "Test String"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val detailItem = LayoutInflater.from(parent?.context).inflate(R.layout.detail_lv_item, parent, false)

        val checkBox = detailItem.findViewById<CheckBox>(R.id.cb_todo)
        val textView = detailItem.findViewById<TextView>(R.id.tv_detail_todo)

        val checked: Boolean = todoList[position].get(1) == 1
        val text: String = todoList[position].get(0) as String

        if(checked){
            checkBox.isChecked = true
//            textView.paint.isStrikeThruText = true
        }
        textView.text = text

        checkBox.setOnClickListener {
            if(checkBox.isChecked){
                db.changeChecked(todoList[position].get(2) as Int, 1)
            }else{
                db.changeChecked(todoList[position].get(2) as Int, 0)
            }
        }
        return detailItem
    }
}
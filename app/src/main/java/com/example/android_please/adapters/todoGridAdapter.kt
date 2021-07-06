package com.example.android_please.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.android_please.R
import com.example.android_please.fragments.DetailFragment
import kotlinx.android.synthetic.main.to_do_card.view.*

class todoGridAdapter(var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        var db = DataBaseHandler(context)
        var dateList = db.dateList()
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
        var finCount = db.getFinCount(dateList[position].get(0).toString())
        todoView.tv_date.text = dateList[position].get(0).toString()
        todoView.tv_numtodo.text = "Todos: "+dateList[position].get(1).toString()
        todoView.tv_numfin.text = "Finished: "+finCount
        todoView.setOnClickListener {
            val intent = Intent(context, DetailFragment::class.java)
            intent.putExtra("date", dateList[position].get(0).toString())
            context.startActivity(intent)
        }
        todoView.setOnLongClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Deleting")
            builder.setMessage("Are you sure you want to delete this date's todos?")
            builder.setPositiveButton("Yes"){dialogInterface:DialogInterface, i:Int->
                db.deleteDate(dateList[position].get(0).toString())
                this.notifyDataSetChanged()
            }
            builder.setNegativeButton("No"){dialogInterface:DialogInterface, i:Int->
            }
            builder.show()
            return@setOnLongClickListener true
        }
        return todoView
    }
}
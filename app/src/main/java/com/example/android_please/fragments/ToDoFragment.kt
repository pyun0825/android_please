package com.example.android_please.fragments

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.android_please.R
import com.example.android_please.ToDoItem
import com.example.android_please.adapters.DataBaseHandler
import com.example.android_please.adapters.ViewPagerAdapter
import com.example.android_please.adapters.todoGridAdapter
import java.util.*

class ToDoFragment(context: Context, var adapter: todoGridAdapter) : DialogFragment() {

    var mCon = context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val RootView = inflater.inflate(R.layout.fragment_to_do, container, false)

        val et_date = RootView.findViewById<EditText>(R.id.et_date)
        val et_todo = RootView.findViewById<EditText>(R.id.et_todo)
        val btn_cancel = RootView.findViewById<Button>(R.id.bt_cancel)
        val btn_submit = RootView.findViewById<Button>(R.id.bt_submit)

        et_date.setOnClickListener {
            var calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)


            var listener = DatePickerDialog.OnDateSetListener{ _, i, i2, i3 ->
                et_date.setText("${i}-${i2}-${i3}")
            }

            var picker = DatePickerDialog(mCon, listener, year, month, day)
            picker.show()
        }

        btn_cancel.setOnClickListener {
            dismiss()
        }

        btn_submit.setOnClickListener {
            if(et_date.text.length>0 && et_todo.text.length>0){
                var todoItem = ToDoItem(et_date.text.toString(), et_todo.text.toString(), false)
                var db = DataBaseHandler(mCon)
                db.insertData(todoItem)
                adapter.notifyDataSetChanged()
                dismiss()
            } else{
                Toast.makeText(context, "Please Fill All the Data!", Toast.LENGTH_SHORT).show()
            }
        }

        return RootView

    }
}
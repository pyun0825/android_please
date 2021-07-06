package com.example.android_please.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.android_please.LinkItem
import com.example.android_please.R
import com.example.android_please.adapters.DataBaseHandler
import com.example.android_please.adapters.DetailLinkAdapter
import kotlinx.android.synthetic.main.fragment_detail.*

class LinkDialogFragment(context: Context, date:String?, adapter: DetailLinkAdapter) : DialogFragment() {
    val adapter = adapter
    val mCon = context
    val date = date
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var RootView =  inflater.inflate(R.layout.fragment_link_dialog, container, false)
        val linkText = RootView.findViewById<EditText>(R.id.et_link)
        val cancelBtn = RootView.findViewById<Button>(R.id.bt_link_cancel)
        val addBtn = RootView.findViewById<Button>(R.id.bt_link_submit)
        cancelBtn.setOnClickListener {
            dismiss()
        }
        addBtn.setOnClickListener {
            if(linkText.text.length > 0){
                var linkItem = LinkItem(date, linkText.text.toString())
                var db = DataBaseHandler(mCon)
                db.insertLink(linkItem)

                activity?.recreate()

                dismiss()
            } else{
                Toast.makeText(context, "Please Fill All the Data!", Toast.LENGTH_SHORT).show()
            }
        }
        return RootView
    }
}
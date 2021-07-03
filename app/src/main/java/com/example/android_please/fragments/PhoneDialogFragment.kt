package com.example.android_please.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.android_please.R
import kotlinx.android.synthetic.main.fragment_phone_dialog.view.*
import org.json.JSONObject
import java.io.File

class PhoneDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView: View =  inflater.inflate(R.layout.fragment_phone_dialog, container, false)

        rootView.dialogCancel.setOnClickListener {
            dismiss()
        }

        rootView.dialogSubmit.setOnClickListener {
            val newName = rootView.editTextName
            val newNumber = rootView.editTextNumber
            val jsonString = "{\"name\": \"${newName}\", \"number\": \"newNumber\"}"
            val jsonObj = JSONObject(jsonString)
            val fileName = "addednumbers.json"

            val path = context?.getFilesDir()
            val letDirectory = File(path, "added")
            letDirectory.mkdirs()

            val file = File(letDirectory, fileName)
        }

        return rootView
    }
}
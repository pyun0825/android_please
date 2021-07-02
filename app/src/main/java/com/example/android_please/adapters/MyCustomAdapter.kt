package com.example.android_please.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.android_please.R
import org.json.JSONObject

class MyCustomAdapter(context: Context): BaseAdapter() {
    val assetManager = context.resources.assets
    val inputStream = assetManager.open("phonenumbers.json")
    val jsonString = inputStream.bufferedReader().use {it.readText()}
    val jObject = JSONObject(jsonString)
    val jArray = jObject.getJSONArray("people")


    private val names = arrayListOf<String>()
    private val numbers = arrayListOf<String>()

    private val mContext: Context

    init {
        mContext = context
        for(i in 0 until jArray.length()) {
            val obj = jArray.getJSONObject(i)
            val name = obj.getString("name")
            val number = obj.getString("number")
            names.add(name)
            numbers.add(number)
        }
    }

    override fun getCount(): Int {
        return names.size //array 크기만큼 Display
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return "TEST STRING"
    }

    //responsible for rendering out each row
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

        val nameTextView = rowMain.findViewById<TextView>(R.id.textView) // 해당 TextArea ID 찾아서 변수에 저장, 안에 Text 변경
        nameTextView.text = names.get(position)

        val positionTextView = rowMain.findViewById<TextView>(R.id.textView2) //동일-position 변수 출력하도록
        positionTextView.text = "Phone Number: ${numbers.get(position)}"

        val avatarImgView = rowMain.findViewById<ImageView>(R.id.avatarImg)
        avatarImgView.setImageResource(R.drawable.profile_image)

        return rowMain
    }

}
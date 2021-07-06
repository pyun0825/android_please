package com.example.android_please

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso

class Single_img : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_img)

        val cardImage : ImageView = findViewById(R.id.singleview)
        var url = intent.getStringExtra("url") as String
        Picasso.get().load(url).into(cardImage)

        var cancel_button = findViewById<Button>(R.id.cancel_button)

        cancel_button.setOnClickListener {
            finish()
        }

    }
}
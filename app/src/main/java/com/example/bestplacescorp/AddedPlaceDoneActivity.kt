package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddedPlaceDoneActivity : AppCompatActivity() {


    lateinit var addMoreButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_added_place_done)

        addMoreButton.findViewById<Button>(R.id.addMoreButton)


        addMoreButton.setOnClickListener {
            val intent = Intent(this, RateNameActivity::class.java)
            startActivity(intent)
        }
    }
}
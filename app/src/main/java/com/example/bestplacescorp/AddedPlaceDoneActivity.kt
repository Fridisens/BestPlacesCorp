package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddedPlaceDoneActivity : AppCompatActivity() {


    lateinit var addMoreButton : Button
    lateinit var listOfPlacesButton: Button
    lateinit var goBackSignedInButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_added_place_done)


        addMoreButton = findViewById<Button>(R.id.addMoreButton)
        listOfPlacesButton = findViewById(R.id.listOfPlacesButton)
        goBackSignedInButton = findViewById(R.id.goBackSignedInButton)

        addMoreButton.setOnClickListener {
            val intent = Intent(this, RateNameActivity::class.java)
            startActivity(intent)
        }

        listOfPlacesButton.setOnClickListener {
            val intent = Intent(this, ListOfPlacesRecyclerView::class.java)
            startActivity(intent)
        }

        goBackSignedInButton.setOnClickListener {
            val intent = Intent(this, AddPlaceActivity::class.java)
            startActivity(intent)
        }


    }
}
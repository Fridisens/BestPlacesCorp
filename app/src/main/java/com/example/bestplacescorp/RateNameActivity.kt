package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class RateNameActivity : AppCompatActivity() {

    lateinit var nameRestaurantEditText : EditText
    lateinit var latLongEditText: EditText
    lateinit var nameNextButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_name)

        nameRestaurantEditText = findViewById(R.id.nameRestaurantEditText)
        latLongEditText = findViewById(R.id.latLongEditText)
        nameNextButton = findViewById(R.id.nameNextButton)

        nameNextButton.setOnClickListener {
            PlaceDataManager.currentPlace.name = nameRestaurantEditText.text.toString()
            val intent = Intent(this, RateFoodActivity::class.java)
            startActivity(intent)
        }
    }
}
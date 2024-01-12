package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class RateFoodActivity : AppCompatActivity() {

    lateinit var foodNextButton: Button
    lateinit var foodRatingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_food)

        foodNextButton = findViewById<Button>(R.id.foodNextButton)
        foodRatingBar = findViewById<RatingBar>(R.id.foodRatingBar)

        foodNextButton.setOnClickListener {

            //Get info from RatingBar
            PlaceDataManager.currentPlace.foodRating = foodRatingBar.rating

            val intent = Intent(this, RateDrinkActivity::class.java)
            startActivity(intent)
        }

    }
}

package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import com.google.firebase.firestore.FirebaseFirestore

class RateDrinkActivity : AppCompatActivity() {

    lateinit var drinkNextButton: Button
    lateinit var drinkRatingBar: RatingBar

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_drink)

        drinkNextButton = findViewById<Button>(R.id.drinkNextButton)
        drinkRatingBar = findViewById<RatingBar>(R.id.drinkRatingBar)

        drinkNextButton.setOnClickListener {
            val drinkRating = drinkRatingBar.rating
            val place = Place(drinkRating = drinkRating)

            db.collection("places")
                .add(place)
                .addOnSuccessListener { documentReference ->
                    // Här kan du göra något när lagringen är framgångsrik
                }
                .addOnFailureListener { e ->
                    // Här kan du hantera fel om lagringen misslyckas
                }

            val intent = Intent(this, RateServiceActivity::class.java)
            startActivity(intent)
        }

        //drinkRatingBar.setOnRatingBarChangeListener { _, _, _, _ ->
            // Du kan hantera eventuella ändringar i värderingen här om det behövs
        }
    }

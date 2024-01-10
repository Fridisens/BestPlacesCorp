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

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_food)



        foodNextButton = findViewById<Button>(R.id.foodNextButton)
        foodRatingBar = findViewById<RatingBar>(R.id.foodRatingBar)

        foodNextButton.setOnClickListener {
            // Hämta värderingen från RatingBar
            val foodRating = foodRatingBar.rating

            // Skapa en ny instans av Place med matvärderingen
            val place = Place(foodRating = foodRating)

            // Spara platsen i Firebase
            db.collection("places")
                .add(place)
                .addOnSuccessListener { documentReference ->
                    // Här kan du göra något när lagringen är framgångsrik
                }
                .addOnFailureListener { e ->
                    // Här kan du hantera fel om lagringen misslyckas
                }

            // Fortsätt till nästa aktivitet
            val intent = Intent(this, RateDrinkActivity::class.java)
            startActivity(intent)
        }

        //foodRatingBar.setOnRatingBarChangeListener { _, _, _, _ ->
            // Du kan hantera eventuella ändringar i värderingen här om det behövs
        }
    }

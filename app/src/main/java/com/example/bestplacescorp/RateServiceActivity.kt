package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import com.google.firebase.firestore.FirebaseFirestore

class RateServiceActivity : AppCompatActivity() {

    lateinit var serviceNextButton: Button
    lateinit var serviceRatingBar : RatingBar

    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_service)

        serviceNextButton = findViewById<Button>(R.id.serviceNextbutton)
        serviceRatingBar = findViewById<RatingBar>(R.id.serviceRatingBar)



        serviceNextButton.setOnClickListener {

            val serviceRating = serviceRatingBar.rating

            val place = Place(serviceRating = serviceRating)

            db.collection("places")
                .add(place)
                .addOnSuccessListener { documentReference ->
                    // Här kan du göra något när lagringen är framgångsrik
                }
                .addOnFailureListener { e ->
                    // Här kan du hantera fel om lagringen misslyckas
                }

            val intent = Intent(this, RateOtherActivity::class.java)
            startActivity(intent)
        }

        //serviceRatingBar.setOnRatingBarChangeListener { _, _, _, _ ->
            // Du kan hantera eventuella ändringar i värderingen här om det behövs
        }
    }

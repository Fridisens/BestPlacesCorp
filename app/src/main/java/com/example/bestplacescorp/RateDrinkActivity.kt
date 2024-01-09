package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar

class RateDrinkActivity : AppCompatActivity() {

    lateinit var drinkNextButton: Button
    lateinit var drinkRatingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_drink)

        drinkNextButton.findViewById<Button>(R.id.drinkNextButton)
        drinkRatingBar.findViewById<RatingBar>(R.id.drinkRatingBar)

        drinkNextButton.setOnClickListener {
            val intent = Intent(this, RateServiceActivity::class.java)
            startActivity(intent)
        }

        drinkRatingBar.setOnRatingBarChangeListener{ _, rating, _, ->
            //Hantera rating?
        }
    }
}
package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar

class RateServiceActivity : AppCompatActivity() {

    lateinit var serviceNextButton: Button
    lateinit var serviceRatingBar : RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_service)

        serviceNextButton.findViewById<Button>(R.id.serviceNextbutton)
        serviceRatingBar.findViewById<RatingBar>(R.id.serviceRatingBar)



        serviceNextButton.setOnClickListener {

            val intent = Intent(this, RateOtherActivity::class.java)
            startActivity(intent)
        }

        serviceRatingBar.setOnRatingBarChangeListener { _, rating, _ ->  }

    }
}

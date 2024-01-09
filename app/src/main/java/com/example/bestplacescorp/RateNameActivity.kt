package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RateNameActivity : AppCompatActivity() {

    lateinit var nameRestaurantEditText : EditText
    lateinit var latLongEditText: EditText
    lateinit var nameNextButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_name)


        nameNextButton = findViewById<Button>(R.id.nameNextButton)

        nameNextButton.setOnClickListener {
            val intent = Intent(this, RateFoodActivity::class.java)
            startActivity(intent)
        }

    }
}
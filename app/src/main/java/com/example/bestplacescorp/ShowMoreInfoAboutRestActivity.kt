package com.example.bestplacescorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class ShowMoreInfoAboutRestActivity : AppCompatActivity() {

    lateinit var restaurantName : TextView
    lateinit var restaurantOtherText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_more_info_about_rest)

        restaurantName = findViewById(R.id.textView3)
        restaurantOtherText = findViewById(R.id.textView4)

        // Hämta restaurangnamnet från intent
        val getRestaurantName = intent.getStringExtra("restaurantName")
        val getRestaurantOtherText = intent.getStringExtra("restaurantOtherText")

        // Uppdatera UI med restauranginformation
        restaurantName.text = getRestaurantName
        restaurantOtherText.text = getRestaurantOtherText
    }
}
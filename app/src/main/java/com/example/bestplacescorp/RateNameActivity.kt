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

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_name)

        nameRestaurantEditText = findViewById(R.id.nameRestaurantEditText)
        latLongEditText = findViewById(R.id.latLongEditText)
        nameNextButton = findViewById(R.id.nameNextButton)

        nameNextButton.setOnClickListener {
            // Hämta värdet från EditText efter att användaren har angett det
            val placeName = nameRestaurantEditText.text.toString()
            val place = Place(name = placeName)

            // Spara platsen i Firebase
            db.collection("places")
                .add(place)
                .addOnSuccessListener { documentReference ->
                    Log.d("!!!", "DocumentSnapshot added with ID: ${documentReference.id}")
                    // Här kan du göra något när lagringen är framgångsrik
                }
                .addOnFailureListener { e ->
                    Log.w("!!!", "Error adding document", e)
                    // Här kan du hantera fel om lagringen misslyckas
                }

            // Fortsätt till nästa aktivitet
            val intent = Intent(this, RateFoodActivity::class.java)
            startActivity(intent)
        }
    }
}
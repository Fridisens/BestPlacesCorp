package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.firebase.firestore.FirebaseFirestore

class RateOtherActivity : AppCompatActivity() {


    lateinit var editTextText : EditText
    lateinit var saveAllButton : Button
    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_other)



        editTextText = findViewById<EditText>(R.id.editTextText)
        saveAllButton = findViewById<Button>(R.id.saveAllButton)


        editTextText.setOnClickListener {
            val placeOtherText = editTextText.text.toString()
            val place = Place(otherText = placeOtherText)
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
        }

        saveAllButton.setOnClickListener {
            val intent = Intent(this, AddedPlaceDoneActivity::class.java)
            startActivity(intent)
        }

    }
}
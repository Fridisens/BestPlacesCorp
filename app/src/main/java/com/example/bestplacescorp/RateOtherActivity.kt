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

        editTextText = findViewById(R.id.editTextText)
        saveAllButton = findViewById(R.id.saveAllButton)

        editTextText.setOnClickListener {
            PlaceDataManager.currentPlace.otherText = editTextText.text.toString()
        }
        saveAllButton.setOnClickListener {
            PlaceDataManager.saveAllInformationToFirestore(
                onSuccess = { documentId ->
                    Log.d("!!!", "DocumentSnapshot added with ID: $documentId")
                },
                onFailure = { e ->
                    Log.w("!!!", "Error adding document", e)
                }
            )
            val intent = Intent(this, AddedPlaceDoneActivity::class.java)
            startActivity(intent)
        }

    }
}
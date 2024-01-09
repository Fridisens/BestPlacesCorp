package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AddPlaceActivity : AppCompatActivity() {

   private val db = FirebaseFirestore.getInstance()

    lateinit var addSignedInButton : Button
    lateinit var goBackButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_place)

        addSignedInButton = findViewById<Button>(R.id.addSignedInButton)
        goBackButton = findViewById(R.id.goBackButton)

        addSignedInButton.setOnClickListener {
            val intent = Intent(this, RateNameActivity::class.java)
            startActivity(intent)
        }
    }
}
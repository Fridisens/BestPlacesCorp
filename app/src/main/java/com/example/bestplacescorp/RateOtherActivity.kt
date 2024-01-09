package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class RateOtherActivity : AppCompatActivity() {


    lateinit var editTextText : EditText
    lateinit var saveAllButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_other)


        editTextText = findViewById<EditText>(R.id.editTextText)
        saveAllButton = findViewById<Button>(R.id.saveAllButton)


        editTextText.addTextChangedListener { editable ->
            val enteredText = editable.toString()
            // Gör något med den inmatade texten - skicka till databas
        }

        saveAllButton.setOnClickListener {
            val intent = Intent(this, AddedPlaceDoneActivity::class.java)
            startActivity(intent)
        }

    }
}
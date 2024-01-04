package com.example.bestplacescorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateAndSignInActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth
    lateinit var emailView : EditText
    lateinit var passwordView : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_sign_in)

        auth = Firebase.auth
        emailView = findViewById(R.id.emailEditText)
        passwordView = findViewById(R.id.passwordEditText)

        val signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener {
            signUp()
        }

        val signInButton = findViewById<Button>(R.id.signInButton)
        signInButton.setOnClickListener {
            signIn()
        }
    }

    fun signIn() {
        val email = emailView.text.toString()
        val password = passwordView.toString()

        if (email.isEmpty() || password.isEmpty()){
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Log.d("!!!", "create success")
                } else {
                    Log.d("!!!", "User not created ${task.exception}")
                }
            }
    }

    fun signUp(){
        val email = emailView.text.toString()
        val password = passwordView.toString()

        if (email.isEmpty() || password.isEmpty()){
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Log.d("!!!", "create success")
                } else {
                    Log.d("!!!", "User not created ${task.exception}")
                }
            }
    }

}
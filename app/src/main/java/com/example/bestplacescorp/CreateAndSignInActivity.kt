package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateAndSignInActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth
    lateinit var emailView : EditText
    lateinit var passwordView : EditText
    lateinit var signInButton: Button
    lateinit var signUpButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_sign_in)

        auth = Firebase.auth
        emailView = findViewById(R.id.emailEditText)
        passwordView = findViewById(R.id.passwordEditText)

        signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener {
            signUp()
        }

        signInButton = findViewById<Button>(R.id.signInButton)
        signInButton.setOnClickListener {
            signIn()
            val intent = Intent(this, AddPlaceActivity::class.java)
            startActivity(intent)
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
                    showSignUpToast("Konto skapat! Du kan nu logga in!")
                    Log.d("!!!", "create success")
                } else {
                    showSignUpToast("Misslyckades att skapa konto, försök igen. ${task.exception?.message}")
                    Log.d("!!!", "User not created ${task.exception}")
                }
            }
    }

    fun showSignUpToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.show()

    }


}
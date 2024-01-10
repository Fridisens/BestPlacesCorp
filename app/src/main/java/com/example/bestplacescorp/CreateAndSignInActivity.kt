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
        }
    }

    fun signIn() {
        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            showSignUpToast("Fyll i både e-postadress och lösenord.")
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Log.d("!!!", "Inloggning lyckades")
                    val currentUser = Firebase.auth.currentUser
                    if (currentUser != null) {
                    val intent = Intent(this, AddPlaceActivity::class.java)
                    startActivity(intent)
                        finish()
                    }
                } else {
                    showSignUpToast("Inloggningen misslyckades: ${task.exception?.message} ")
                }

            }
    }

    fun signUp(){
        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            showSignUpToast("Fyll i både e-postadress och lösenord.")
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    showSignUpToast("Konto skapat! Du kan nu logga in!")
                    Log.d("!!!", "Registrering lyckades")
                } else {
                    showSignUpToast("Misslyckades att skapa konto, försök igen. ${task.exception?.message}")
                    Log.d("!!!", "Registrering misslyckades: ${task.exception}")
                }
            }
    }

    fun showSignUpToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.show()

    }


}
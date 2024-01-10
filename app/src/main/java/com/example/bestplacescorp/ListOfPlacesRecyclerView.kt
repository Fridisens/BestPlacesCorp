package com.example.bestplacescorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class ListOfPlacesRecyclerView : AppCompatActivity() {

    var restaurants = mutableListOf<Restaturant>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_places_recycler_view)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RestaurantRecyclerAdapter(this, restaurants)
        recyclerView.adapter = adapter

        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        firestore.collection("places")
            .get()
            .addOnSuccessListener { querySnapshot ->
                // Rensa befintliga data i listan innan du fyller på den
                restaurants.clear()

                for (document in querySnapshot.documents){
                    val restaturant = document.toObject(Restaturant::class.java)
                    restaturant?.let {
                        restaurants.add(it)
                    }
                }

            }
    }

}
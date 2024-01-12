package com.example.bestplacescorp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase

class ListOfPlacesRecyclerView : AppCompatActivity() {

    var restaurants = mutableListOf<Place>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_places_recycler_view)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager

        val adapter = RestaurantRecyclerAdapter(this, restaurants){ restaurant ->
            val intent = Intent(this, ShowMoreInfoAboutRestActivity::class.java)
            intent.putExtra("restaurantName", restaurant.name)
            intent.putExtra("restaurantOtherText", restaurant.otherText)
            intent.putExtra("foodRating", restaurant.foodRating)
            intent.putExtra("drinkRating",restaurant.drinkRating)
            intent.putExtra("serviceRating", restaurant.serviceRating)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        val spaceHeightInPixels = resources.getDimensionPixelSize(R.dimen.item_spacing)

        recyclerView.addItemDecoration(ItemDecoration(spaceHeightInPixels))

        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        firestore.collection("places")
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents){
                    val restaturant = document.toObject(Place::class.java)
                    restaturant?.let {
                        restaurants.add(it)
                    }
                }
                adapter.notifyDataSetChanged()
            }
    }
}
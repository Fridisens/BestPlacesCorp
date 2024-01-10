package com.example.bestplacescorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListOfPlacesRecyclerView : AppCompatActivity() {

    var restaurants = mutableListOf<Restaturant>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_places_recycler_view)



        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RestaurantRecyclerAdapter(this, restaurants)

        recyclerView.adapter = adapter
    }
}
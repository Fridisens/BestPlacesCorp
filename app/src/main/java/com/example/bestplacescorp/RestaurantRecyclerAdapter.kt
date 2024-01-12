package com.example.bestplacescorp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantRecyclerAdapter (val context: Context, val restaurants : List<Place>, val onItemClick: (Place)-> Unit) : RecyclerView.Adapter<RestaurantRecyclerAdapter.ViewHolder>() {


    var layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.nameTextView.text = restaurant.name
        holder.moreInfoButton.setOnClickListener {
            onItemClick(restaurant)
        }
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView = itemView.findViewById<TextView>(R.id.restaurantNameTextView)
        var moreInfoButton = itemView.findViewById<Button>(R.id.moreInfoButton)

    }
}
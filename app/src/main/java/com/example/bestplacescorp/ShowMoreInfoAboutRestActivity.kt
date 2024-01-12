package com.example.bestplacescorp

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView


class ShowMoreInfoAboutRestActivity : AppCompatActivity() {

    lateinit var restaurantName : TextView
    lateinit var restaurantOtherText: TextView
    lateinit var summaryRatingBar: RatingBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_more_info_about_rest)

        restaurantName = findViewById(R.id.textView3)
        restaurantOtherText = findViewById(R.id.textView4)
        summaryRatingBar = findViewById(R.id.summaryRatingBar)

       // get names from intents for each restaurant
        val getRestaurantName = intent.getStringExtra("restaurantName")
        val getRestaurantOtherText = intent.getStringExtra("restaurantOtherText")
        val getFoodRating = intent.getFloatExtra("foodRating", 0.0f)
        val getDrinkRating = intent.getFloatExtra("drinkRating", 0.0f)
        val getServiceRating = intent.getFloatExtra("serviceRating", 0.0f)

        restaurantName.text = getRestaurantName
        restaurantOtherText.text = getRestaurantOtherText


        val averageRating = (getFoodRating + getDrinkRating + getServiceRating) / 3.0
        summaryRatingBar.rating = averageRating.toFloat()

        val color = getColorForRating(averageRating)
        summaryRatingBar.progressDrawable.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

    }

    private fun getColorForRating(rating: Double): Int {
        return when {
            rating >= 4.0 -> getColor(R.color.highRatingColor)
            rating >= 3.0 -> getColor(R.color.mediumRatingColor)
            else -> getColor(R.color.lowRatingColor)
        }
    }
}

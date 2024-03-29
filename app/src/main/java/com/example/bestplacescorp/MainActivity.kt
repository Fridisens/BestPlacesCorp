package com.example.bestplacescorp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.firebase.FirebaseApp


class MainActivity : AppCompatActivity() {

    private val REQUEST_LOCATION = 1
    lateinit var locationProvider : FusedLocationProviderClient
    lateinit var locationRequest : LocationRequest
    lateinit var locationCallback: LocationCallback


    lateinit var addButton: Button
    lateinit var listAllRestaurantsButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)



        addButton = findViewById(R.id.addButton)
        listAllRestaurantsButton = findViewById(R.id.listAllRestaurantsButton)


        addButton.setOnClickListener {
            val intent = Intent(this, CreateAndSignInActivity::class.java)
            startActivity(intent)
        }

        listAllRestaurantsButton.setOnClickListener {
            val intent = Intent(this, ListOfPlacesRecyclerView::class.java)
            startActivity(intent)
        }

        locationProvider = LocationServices.getFusedLocationProviderClient(this)
        locationRequest = LocationRequest.Builder(2000).build()
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations){
                    Log.d("!!!", "lat: ${location.latitude}, lng ${location.longitude}")
                }
            }
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION
            )
        }
    }



    override fun onResume() {
        super.onResume()
        startLocationUpdates()
    }

    override fun onPause() {
        super.onPause()
        stopLocationUpdates()
    }

    fun stopLocationUpdates(){
        locationProvider.removeLocationUpdates(locationCallback)
    }

    fun startLocationUpdates(){
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED)
            locationProvider.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_LOCATION){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startLocationUpdates()

            }
        }
    }
}
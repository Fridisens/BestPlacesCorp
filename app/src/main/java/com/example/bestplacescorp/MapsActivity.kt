package com.example.bestplacescorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.bestplacescorp.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        createMarker()



    }

    fun createMarker(){
       var sthlm = LatLng(59.3,18.0)
       var vaxjo = LatLng(56.8,14.8)
       var goteborg = LatLng(57.7, 11.9)

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sthlm))



       var marker1 = mMap.addMarker(
           MarkerOptions()
               .position(sthlm)
               .title("Aira, Stockholm")
               .snippet("Bästa kött")

       )

        var marker2 = mMap.addMarker(
            MarkerOptions()
                .position(vaxjo)
                .title("PM & Vänner, Växjö")
                .snippet("Bästa vin")
        )

        var marker3 = mMap.addMarker(
            MarkerOptions()
                .position(goteborg)
                .title("Hoze, Göteborg")
                .snippet("Bästa uteservering")
        )
    }

}
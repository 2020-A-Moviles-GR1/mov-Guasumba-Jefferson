package com.example.moviles

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(),
    OnMapReadyCallback,
        GoogleMap.OnCameraMoveStartedListener,
        GoogleMap.OnCameraMoveListener,
        GoogleMap.OnCameraIdleListener,
        GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener



{

    private lateinit var mMap: GoogleMap
    var tienePermisos=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        solicitarPermisos()

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
        //1.Permisos


        establecerConfiguracionMapa(mMap)
        establecerListeners(mMap)
        val pintado =LatLng(-0.257022, -78.543200)
        val puntoUsuario =LatLng(-0.258031, -78.544123)

        val zoom= 17f
        val titulo = "El pintado"

        anadirMarcador(pintado, titulo)
        moverCamaraConZoom(puntoUsuario, zoom)

        val poliLineaUno= googleMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .add(
                    LatLng(-0.246724, -78.534972),
                    LatLng(-0.246220, -78.534242),
                    LatLng(-0.247819, -78.533985),
                    LatLng(-0.248806, -78.534607)
                )
        )


        val poligonoUno= googleMap.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(-0.250008, -78.532075),
                    LatLng(-0.248688, -78.530863),
                    LatLng(-0.249171, -78.529554),
                    LatLng(-0.250673, -78.529254)
                )
        )

        poligonoUno.fillColor = 0xc771c4


        // Add a marker in Sydney and move the camera
       // val sydney = LatLng(-34.0, 151.0)
       // mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


    fun moverCamaraConZoom(latLng: LatLng, zoom: Float=10f){

        mMap.moveCamera(
            CameraUpdateFactory
                .newLatLngZoom(latLng, zoom)
        )


    }
    fun anadirMarcador(latLng: LatLng, title:String){
        mMap.addMarker(

            MarkerOptions()
                .position(latLng)
                .title(title)
        )
    }


    fun establecerConfiguracionMapa(mapa: GoogleMap){

        val contexto = this.applicationContext
        with(mapa){
            val permisosFineLocation= ContextCompat
                .checkSelfPermission(
                    contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            val tienePermisos=permisosFineLocation == PackageManager.PERMISSION_GRANTED

            if(tienePermisos){
                mapa.isMyLocationEnabled = true
            }

            uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true

        }
    }

    fun solicitarPermisos(){
        val permisosFineLocation= ContextCompat
            .checkSelfPermission(
                this.applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        val tienePermisos=permisosFineLocation == PackageManager.PERMISSION_GRANTED

        if(tienePermisos){
                Log.i("mapa", "Tiene permisos de FINE LOCATION")
            this.tienePermisos=true
        }else{

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1
            )

        }
    }

    fun establecerListeners(map:GoogleMap){
        with(map){
            setOnCameraIdleListener (this@MapsActivity)
            setOnCameraMoveStartedListener (this@MapsActivity )
            setOnCameraMoveListener (this@MapsActivity )
            setOnPolylineClickListener  (this@MapsActivity )
            setOnPolygonClickListener (this@MapsActivity )

        }

    }

    override fun onCameraMoveStarted(p0: Int) {
        Log.i("mapa", "Empezando a mover onCameraMoveStarted")
    }

    override fun onCameraMove() {
        Log.i("mapa", "Moviendo onCameraMove")
    }

    override fun onCameraIdle() {
        Log.i("mapa", "Quieto onCameraIdle")
    }

    override fun onPolylineClick(p0: Polyline?) {
        Log.i("mapa", "Polylinea ${p0.toString()}")
    }

    override fun onPolygonClick(p0: Polygon?) {
        Log.i("mapa", "Polygono ${p0.toString()}")
    }


}
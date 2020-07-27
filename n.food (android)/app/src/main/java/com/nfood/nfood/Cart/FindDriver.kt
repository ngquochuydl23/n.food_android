package com.nfood.nfood.Cart

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.MarkerOptions
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.CustomDialog.DriverInformationDto
import com.nfood.nfood.CustomDialog.FoundDriverDialog
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_find_driver.*

class FindDriver : BaseActivity(), OnMapReadyCallback, PermissionsListener {

  private var permissionsManager: PermissionsManager = PermissionsManager(this)
  private lateinit var mapboxMap: MapboxMap

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Mapbox.getInstance(this, getString(R.string.map_box))
    setContentView(R.layout.activity_find_driver)
    mapBox.onCreate(savedInstanceState)
    getActionBar(header,getString(R.string.find_driver))
    getMap()
    FoundDriver()
  }

  private fun cancelAction(){

  }

  private fun FoundDriver(){

    val driverInfo = DriverInformationDto().apply {
      driverName = "Vũ Hoàng Uyên Nhi"
      driverMotor = "49B1-407.41-Yamaha Exciter 150"
      phoneNumber = "0868684961"
      driverAvatar = "https://scontent.fdad3-1.fna.fbcdn.net/v/t1.0-9/39807922_117240419220780_7597910125738721280_o.jpg?_nc_cat=102&_nc_sid=174925&_nc_oc=AQkFU-QWeO9oujaql9COyqsAQsPpDFyxLskTBEiuzX_llIj36-OjhF1H9PESO4XcjNE&_nc_ht=scontent.fdad3-1.fna&oh=5d849f9e4a33dc2fe09821d799bb77e1&oe=5F013497"
      driverRated = 4.5F
    }

    FoundDriverDialog(this@FindDriver).apply {
      driverInformation = driverInfo
      onBlindDialog()
      showDialog()
    }
  }

  override fun onMapReady(mapboxMap: MapboxMap) {
    this.mapboxMap = mapboxMap
    getNearDriver()

    mapboxMap.setStyle(Style.LIGHT) {
      enableLocationComponent(it)
      getCurrentLocation()
    }
  }
  @SuppressLint("MissingPermission")
  private fun enableLocationComponent(loadedMapStyle: Style) {
    // Check if permissions are enabled and if not request
    if (PermissionsManager.areLocationPermissionsGranted(this)) {
      // Create and customize the LocationComponent's options
      val customLocationComponentOptions = LocationComponentOptions.builder(this)
        .trackingGesturesManagement(true)
        .build()

      val locationComponentActivationOptions =
        LocationComponentActivationOptions.builder(this, loadedMapStyle)
          .locationComponentOptions(customLocationComponentOptions)
          .build()

      // Get an instance of the LocationComponent and then adjust its settings
      mapboxMap.locationComponent.apply {
        // Activate the LocationComponent with options
        activateLocationComponent(locationComponentActivationOptions)
        // Enable to make the LocationComponent visible
        isLocationComponentEnabled = true
        // Set the LocationComponent's camera mode
        cameraMode = CameraMode.TRACKING
        // Set the LocationComponent's render mode
        renderMode = RenderMode.COMPASS

      }
    } else {
      permissionsManager = PermissionsManager(this)
      permissionsManager.requestLocationPermissions(this)
    }
  }
  override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {

  }

  override fun onPermissionResult(granted: Boolean) {

  }

  private fun getNearDriver(){

  }

  private fun getCurrentLocation(){
    val location = mapboxMap.locationComponent.lastKnownLocation
    Log.d("first",location!!.latitude.toString())
    Log.d("second",location!!.longitude.toString())
  }

  private fun getMap() {
    mapBox.getMapAsync(this)
  }

  override fun onStart() {
    super.onStart()
    mapBox.onStart()
  }
  override fun onLowMemory() {
    super.onLowMemory()
    mapBox.onLowMemory()
  }

  override fun onResume() {
    super.onResume()
    mapBox.onResume()
  }

  override fun onPause() {
    super.onPause()
    mapBox.onPause()
  }

  override fun onDestroy() {
    super.onDestroy()
    mapBox.onDestroy()
  }

  override fun onStop() {
    super.onStop()
    mapBox.onStop()
  }
}

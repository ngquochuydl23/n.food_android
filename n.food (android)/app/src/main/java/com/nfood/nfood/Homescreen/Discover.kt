package com.nfood.nfood.Homescreen

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.nfood.nfood.Base.BaseFragment
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_discover.*


class Discover : BaseFragment(), OnMapReadyCallback, PermissionsListener {

  private var permissionsManager: PermissionsManager = PermissionsManager(this)
  private lateinit var mapboxMap: MapboxMap

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    Mapbox.getInstance(
      getContext()!!.getApplicationContext(),
      getString(R.string.map_box)
    )
    return inflater.inflate(R.layout.fragment_discover, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mapView.onCreate(savedInstanceState)
    header.text = getString(R.string.discover)
    getMap()
  }

  override fun onMapReady(mapboxMap: MapboxMap) {
    this.mapboxMap = mapboxMap
    progress_bar.visibility = View.GONE
    mapboxMap.setStyle(
      Style.LIGHT
    ) {
      enableLocationComponent(it)
    }
  }

  @SuppressLint("MissingPermission")
  private fun enableLocationComponent(loadedMapStyle: Style) {
    // Check if permissions are enabled and if not request
    if (PermissionsManager.areLocationPermissionsGranted(context!!)) {
      // Create and customize the LocationComponent's options
      val customLocationComponentOptions = LocationComponentOptions.builder(context!!)
        .trackingGesturesManagement(true)
        .build()

      val locationComponentActivationOptions =
        LocationComponentActivationOptions.builder(context!!, loadedMapStyle)
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
      permissionsManager.requestLocationPermissions(context as Activity)
    }
  }


  override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onPermissionResult(granted: Boolean) {
    if (granted) {
      enableLocationComponent(mapboxMap.style!!)
    }
  }

  override fun onLowMemory() {
    super.onLowMemory()
    mapView.onLowMemory()
    Log.d("status", "onLowMemory")
  }

  override fun onStart() {
    super.onStart()
    mapView.onStart()
    Log.d("status", "start")
  }

  override fun onResume() {
    super.onResume()
    Log.d("status", "onResume")
    mapView.onResume()
  }

  override fun onPause() {
    super.onPause()
    Log.d("status", "onPause")
    mapView.onPause()
  }

  override fun onDetach() {
    Log.d("status", "onDetach")
    super.onDetach()
  }

  override fun onStop() {
    super.onStop()
    Log.d("status", "onStop")
    mapView.onStop()
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.d("status", "onDestroy")
    mapView.onDestroy()
  }

  private fun getMap() {
    mapView.getMapAsync(this)
  }
}

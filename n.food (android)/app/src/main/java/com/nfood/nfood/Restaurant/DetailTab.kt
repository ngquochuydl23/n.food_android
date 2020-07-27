package com.nfood.nfood.Restaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style

import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_details.*


class DetailTab : Fragment(), OnMapReadyCallback {

  private lateinit var mapboxMap: MapboxMap

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    Mapbox.getInstance(
      getContext()!!.getApplicationContext(),
      "pk.eyJ1IjoibmdxdW9jaHV5ZGwyMyIsImEiOiJjazlxdXE1eXYwbnRqM2VydGZpendjYmF4In0.qjMJLsMzKkauG8ccu29IiA"
    )
    return inflater.inflate(R.layout.fragment_details, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    getMap()
  }
  override fun onMapReady(mapboxMap: MapboxMap) {
    this.mapboxMap = mapboxMap
    mapboxMap.setStyle(
      Style.LIGHT
    ) {

    }
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


  override fun onStop() {
    super.onStop()
    mapBox.onStop()
  }
}

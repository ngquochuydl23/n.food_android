package com.nfood.nfood

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class SharePreferencesKey {
  val token = "Token"
  val userInformation = "userInformation"
}

class Layout {
  val horizontal = "horizontalList"
  val vertical = "verticalList"
  val grid = "gridList"
}

class DevideWindow(val context : Context) {
  val displayMetrics = DisplayMetrics()
  val windowManager : WindowManager = context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
  fun width() : Int {
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
  }
  fun height() : Int {
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
  }
}

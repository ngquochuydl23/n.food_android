package com.nfood.nfood

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Homescreen.Homescreen

class Splashscreen : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splashscreen)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      getWindow().setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
    Handler().postDelayed(Run, 3000)
  }
  private val Run = object : Runnable {
    override fun run() {
      val intent = Intent(this@Splashscreen, Homescreen::class.java)
      startActivity(intent)
      finish()
    }
  }

}

package com.nfood.nfood.Profile.AboutNFood

import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_about_nfood.*

class AboutNFood : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_about_nfood)
    getActionBar(header, getString(R.string.about_nfood))
  }
}

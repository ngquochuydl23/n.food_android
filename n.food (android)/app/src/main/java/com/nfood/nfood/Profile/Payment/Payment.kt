package com.nfood.nfood.Profile.Payment

import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_payment.*

class Payment : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_payment)
    getActionBar(header,title.toString())
  }
}

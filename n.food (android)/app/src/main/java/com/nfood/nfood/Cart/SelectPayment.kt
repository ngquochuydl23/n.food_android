package com.nfood.nfood.Cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity

import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_select_payment.*


class SelectPayment : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_payment)
    getActionBar(header,getString(R.string.select_payment))
  }
}

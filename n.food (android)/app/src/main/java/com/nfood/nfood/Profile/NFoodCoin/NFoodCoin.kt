package com.nfood.nfood.Profile.NFoodCoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_nfood_coin.*

class NFoodCoin : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_nfood_coin)
    getActionBar(header,title.toString())
  }
}

package com.nfood.nfood.Profile.MyVoucher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_detail_voucher.*

class DetailVoucher : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail_voucher)
    getActionBar(header,title.toString())
  }
}

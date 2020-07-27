package com.nfood.nfood.Profile.Setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_setting.*

class Setting : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_setting)
    getActionBar(header,title.toString())
    myPasswordClick.setOnClickListener {
      myPassword()
    }
  }
  private fun myPassword(){
    val intent = Intent(this,UpdatePassword::class.java)
    startActivity(intent)
  }
}

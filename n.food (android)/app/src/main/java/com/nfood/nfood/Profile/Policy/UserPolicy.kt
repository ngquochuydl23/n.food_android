package com.nfood.nfood.Profile.Policy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_user_policy.*

class UserPolicy : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_user_policy)
    getActionBar(header, getString(R.string.user_policy))
  }
}

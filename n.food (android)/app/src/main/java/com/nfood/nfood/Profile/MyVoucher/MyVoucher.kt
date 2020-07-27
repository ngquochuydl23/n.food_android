package com.nfood.nfood.Profile.MyVoucher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nfood.nfood.Adapter.PageAdapter.TabLayoutAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_my_voucher.*

class MyVoucher : BaseActivity() {

  private val validVoucher = ValidVoucher()
  private val usedVoucher = UsedVoucher()
  private val invalidVoucher = InvalidVoucher()

  private val listPage = arrayListOf<Fragment>(
    validVoucher,
    usedVoucher,
    invalidVoucher
  )
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_voucher)
    getActionBar(header,title.toString())
    getPage()
  }
  private fun getPage(){
    viewPager.adapter = TabLayoutAdapter(supportFragmentManager).apply {
      size = tabLayout.tabCount
      listFragmentPager = listPage
    }
    getViewPaper(viewPager,tabLayout)
  }
}

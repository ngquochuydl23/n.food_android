package com.nfood.nfood.Profile.MyPurchases

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nfood.nfood.Adapter.PageAdapter.TabLayoutAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_my_purchases.*

class MyPurchases : BaseActivity() {

  private val onGoingPurchases = OnGoingPurchases()
  private val completePurchases = CompletePurchases()
  private val cancelledPurchases = CancelledPurchases()
  private val returnFundPurchases = ReturnFundPurchases()

  private val listPage = arrayListOf<Fragment>(
    onGoingPurchases,
    completePurchases,
    cancelledPurchases,
    returnFundPurchases
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_purchases)
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

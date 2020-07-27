package com.nfood.nfood.Homescreen

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.nfood.nfood.Adapter.RecycleView.SearchResultAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import com.nfood.nfood.Restaurant.RestaurantDto
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchResult : BaseActivity() {

  private val NEAR_BY = 0
  private val TOP_SALE = 1
  private val BEST_RATED = 2
  private val FAST_DELIVERY = 3


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search_result)
    toolbar.setNavigationOnClickListener {
      finish()
    }
    recycleView.layoutManager = LinearLayoutManager(this)
    var keyword = intent.getStringExtra("SearchResult")
    search_bar.setText(keyword)
    search_bar.setOnEditorActionListener(object : TextView.OnEditorActionListener {
      override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
          continueSearch(keyword)
          return true
        }
        return false
      }
    })
    getNearByList()
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab) {
        getListSearchResult(tab.position)
      }
      override fun onTabUnselected(tab: TabLayout.Tab) {}
      override fun onTabReselected(tab: TabLayout.Tab) {}
    })

  }

  private fun continueSearch(keyword: String) {

  }


  private fun getListSearchResult(tabPosition: Int) {
    when (tabPosition) {
      NEAR_BY -> getNearByList()
      TOP_SALE -> getTopSaleList()
      BEST_RATED -> getBestRated()
      FAST_DELIVERY -> getFastDeliveryList()
    }
  }

  private fun getNearByList() {
    var result = SearchResultDto().apply {
      restaurant = RestaurantDto().apply {
        restaurantName = "The Coffee House"
        restaurantAddress = "313 Nguyễn Thị Thập,P.Tân Phong, Q7, TP.HCM"
        isVerify = true
        restaurantImage = "https://khuyenmaiviet.vn/wp-content/uploads/2019/03/52974568_2295418694065477_8556048193387757568_n.jpg"
      }
    }
    var listSearchResult = arrayListOf<SearchResultDto>()
    listSearchResult.add(result)
    listSearchResult.add(result)
    listSearchResult.add(result)
    listSearchResult.add(result)
    recycleView.adapter = SearchResultAdapter(listSearchResult)
  }

  private fun getTopSaleList() {
    var result = SearchResultDto().apply {
      restaurant = RestaurantDto().apply {
        restaurantName = "GongCha - Phú Mỹ Hưng HCM"
        restaurantAddress = "175 Tôn Dật Tiên,P.Tân Phong,Q7,TP.HCM"
        isVerify = true
        restaurantImage = "https://khuyenmaiviet.vn/wp-content/uploads/2019/06/61272860_2392236764343460_1787669159300038656_n.jpg"
      }
    }
    var listSearchResult = arrayListOf<SearchResultDto>()
    listSearchResult.add(result)
    listSearchResult.add(result)
    listSearchResult.add(result)
    listSearchResult.add(result)
    recycleView.adapter = SearchResultAdapter(listSearchResult)
  }

  private fun getBestRated() {
    var result = SearchResultDto().apply {
      restaurant = RestaurantDto().apply {
        restaurantName = "Toco Toco"
        restaurantAddress = "465 Nguyễn Thị Thập, Tân Phong, Quận 7, TP.HCM"
        isVerify = true
        restaurantImage = "https://getcoupon.vn/wp-content/uploads/2017/08/tocotoco-khuyen-mai.jpg"
      }
    }
    var listSearchResult = arrayListOf<SearchResultDto>()
    listSearchResult.add(result)
    listSearchResult.add(result)
    listSearchResult.add(result)
    listSearchResult.add(result)
    recycleView.adapter = SearchResultAdapter(listSearchResult)
  }

  private fun getFastDeliveryList() {
    recycleView.adapter = null
  }

}

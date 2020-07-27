package com.nfood.nfood.Restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.ListTabAdapter
import com.nfood.nfood.Adapter.RecycleView.MenuParentAdapter
import com.nfood.nfood.Base.BaseFragment
import com.nfood.nfood.Interface_Service.*
import com.nfood.nfood.Layout
import com.nfood.nfood.Models.ItemMenuChildDto
import com.nfood.nfood.Models.ItemMenuParentDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_favourite.*

class HomeTab : BaseFragment() {

  private var listTab = arrayListOf<Tab>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_favourite, container, false)


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    listFood.layoutManager = LinearLayoutManager(context)
    getListFood()

  }
  private fun getListFood(){
    val product = ItemMenuChildDto().apply {
      productName = "Trà Sữa Xoài Trân Châu Đen"
      productPrice = "40.000đ"
      isSoldOut = true
      productImage = "https://gongcha.com.vn/wp-content/uploads/2019/06/Mango-Milktea.png"
    }
    val product1 = ItemMenuChildDto().apply {
      productName = "Trà sữa Okinawa"
      productPrice = "40.000đ"
      isSoldOut = true
      productImage = "https://gongcha.com.vn/wp-content/uploads/2018/10/Hinh-Web-OKINAWA-TR%C3%80-S%E1%BB%AEA.png"
    }
    val product2 = ItemMenuChildDto().apply {
      productName = "Trà Sữa Matcha Đậu Đỏ"
      productPrice = "40.000đ"
      isSoldOut = true
      productImage = "https://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Matcha-%C4%91%E1%BA%ADu-%C4%91%E1%BB%8F-2.png"
    }
    val menuParent = ItemMenuParentDto().apply {
      menuTitle = "Bán chạy"
      listMenuChild = arrayListOf(product,product1,product2)
    }
    listFood.adapter = MenuParentAdapter(arrayListOf(menuParent), Layout().grid)
  }
}


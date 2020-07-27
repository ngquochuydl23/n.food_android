package com.nfood.nfood.Profile.MyPurchases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.OrderAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Cart.OrderRestaurantDto
import com.nfood.nfood.Homescreen.OrderProductDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_order_detail.*

class OrderDetail : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_order_detail)
    getActionBar(header, getString(R.string.order_detail))


    recyclerView.layoutManager = LinearLayoutManager(this)
    getStepView()

    ////////////////////////////////////////////////////
    val orderItem1 = OrderProductDto().apply {
      productName = "Gongcha Matcha"
      productNumber = 2
      productCost = "40.000đ"
      productImage = "https://gongcha.com.vn/wp-content/uploads/2018/10/Hinh-Web-OKINAWA-TR%C3%80-S%E1%BB%AEA.png"

    }
    val orderItem2 = OrderProductDto().apply {
      productName = "Gongcha Okinawa"
      productNumber = 1
      productNote = "Ít đường"
      productCost = "40.000đ"
      productImage = "https://gongcha.com.vn/wp-content/uploads/2018/10/Hinh-Web-OKINAWA-SUA-TUOI.png"

    }
    val orderItem3 = OrderProductDto().apply {
      productName = "Trà sữa trân châu hoàng gia"
      productNumber = 1
      productCost = "22.000đ"
      productImage = "https://product.hstatic.net/1000355252/product/upload_ed6d6a235c0d42f588998e76ae0a91c9.jpg"

    }
    val restaurant = arrayListOf<OrderProductDto>()
    restaurant.add(orderItem1)
    restaurant.add(orderItem2)
    var listOrder1 = OrderRestaurantDto().apply {
      restaurantName = "Gongcha Phú Mỹ Hưng"
      listOrder = restaurant
    }
    val list  = arrayListOf<OrderRestaurantDto>()
    list.add(listOrder1)




    val kfc = arrayListOf<OrderProductDto>()
    kfc.add(orderItem3)

    val listOrder2 = OrderRestaurantDto().apply {
      restaurantName = "Toco Toco"
      listOrder = kfc
    }
    list.add(listOrder2)
    orderStatus.setOnClickListener {
      orderStatusContent.toggle()
    }

    cancelOrder.visibility = View.GONE
    recyclerView.adapter = OrderAdapter(list)

  }

  private fun getStepView(){
    val stepString = arrayListOf<String>("Submitted","Confirmed","Assigned","Picked","Completed")

  }
}

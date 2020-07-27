package com.nfood.nfood.Homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.RestaurantAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import com.nfood.nfood.Restaurant.RestaurantDto
import kotlinx.android.synthetic.main.activity_view_more.*

class ViewMore : BaseActivity() {
  private val Title = "Title"
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_more)
    initData()
    listRestaurant.layoutManager = LinearLayoutManager(this)
    getListRestaurant()
  }

  private fun getListRestaurant(){

    val tocotoco = RestaurantDto().apply {
      restaurantName = "Toco Toco"
      restaurantAddress = "465 Nguyễn Thị Thập, P.Tân Phong, Quận 7, TP.HCM"
      ratedNumber = 4.0
      isVerify = true
      restaurantImage = "https://getcoupon.vn/wp-content/uploads/2017/08/tocotoco-khuyen-mai.jpg"
    }
    val gongcha = RestaurantDto().apply {
      restaurantName = "Gongcha Phú Mỹ Hưng"
      restaurantAddress = "175 Tôn Dật Tiên, P.Tân Phong, Quận 7, TP.HCM"
      ratedNumber = 4.0
      isVerify = true
      restaurantImage = "https://khuyenmaiviet.vn/wp-content/uploads/2019/06/61272860_2392236764343460_1787669159300038656_n.jpg"
    }
    val listRestaurantArray = ArrayList<RestaurantDto>()
    listRestaurantArray.add(gongcha)
    listRestaurantArray.add(tocotoco)
    listRestaurantArray.add(gongcha)
    listRestaurantArray.add(tocotoco)
    listRestaurantArray.add(gongcha)
    listRestaurantArray.add(tocotoco)



    listRestaurant.adapter = RestaurantAdapter(listRestaurantArray)
  }

  private fun initData(){
    val bundle = intent.extras
    if(bundle != null)
      getActionBar(header,bundle!!.getString(Title)!!)
  }
}

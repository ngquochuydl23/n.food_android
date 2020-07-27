package com.nfood.nfood.Profile.MyPurchases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.MyOrderAdapter
import com.nfood.nfood.Cart.OrderRestaurantDto
import com.nfood.nfood.Homescreen.RestaurantOrderDto
import com.nfood.nfood.Profile.PuschasesRestaurantDto

import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_on_going_purchases.*

class OnGoingPurchases : Fragment() {

  private val listItem = arrayListOf<PuschasesRestaurantDto>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_on_going_purchases, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val orderRestaurant = RestaurantOrderDto().apply {
      restaurantName = "Bò né 3 ngon"
      restaurantAddress = "465 Nguyễn Thị Thập,P.Tân Phong, Quận 7, TP.HCM"
      restaurantCash = "40.000đ (1 Item) - Cash"
      restaurantImage = "https://anh.eva.vn/upload/4-2017/images/2017-11-26/1511665266-551-2.jpg"
    }
    val toco = RestaurantOrderDto().apply {
      restaurantName = "Mỹ Ý 4B"
      restaurantAddress = "465 Nguyễn Thị Thập, Tân Phong, Quận 7, TP.HCM"
      restaurantCash = "22.000đ (1 Item) - Cash"
      restaurantImage = "https://bepanvanphong.vn/contents_spa/images/1(4).jpg"
    }

    val item = PuschasesRestaurantDto().apply {
      idOrder =  "#140203"
      deliveryStatus = "OnGoing"
      date = "23/03/2020"
      listOrderRestaurant = arrayListOf(orderRestaurant,toco)
    }
    val item1 = PuschasesRestaurantDto().apply {
      idOrder =  "#220903"
      deliveryStatus = "OnGoing"
      date = "12/01/2020"
      listOrderRestaurant = arrayListOf(orderRestaurant,toco)
    }
    listItem.add(item)
    listItem.add(item1)
    recyclerView.layoutManager = LinearLayoutManager(context)
    recyclerView.adapter = MyOrderAdapter(listItem)
  }
}

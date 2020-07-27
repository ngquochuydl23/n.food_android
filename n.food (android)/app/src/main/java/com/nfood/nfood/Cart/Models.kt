package com.nfood.nfood.Cart

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nfood.nfood.Homescreen.OrderProductDto

class OrderRestaurantDto{
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  @SerializedName("listOrderRestaurant")
  @Expose
  var listOrder: ArrayList<OrderProductDto>? = null
}
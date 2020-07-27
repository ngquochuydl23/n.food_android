package com.nfood.nfood.Interface_Service

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nfood.nfood.Homescreen.*
import com.nfood.nfood.Models.ItemProductDto
import com.nfood.nfood.Notification.NotificationDto
import com.nfood.nfood.Restaurant.RestaurantDto
import retrofit2.Call
import retrofit2.http.GET



class Tab {
  @SerializedName("title")
  @Expose
  var title : String? = null
  @SerializedName("list")
  @Expose
  var list : String? = null
  @SerializedName("type")
  @Expose
  var type : String? = null
  @SerializedName("restaurantList")
  @Expose
  var restaurantList : ArrayList<RestaurantDto>? = null
  @SerializedName("productList")
  @Expose
  var productList : ArrayList<ItemProductDto>? = null
}

class ListTab {
  @SerializedName("listTab")
  @Expose
  var listTab : ArrayList<Tab>? = null
  @SerializedName("listSlide")
  @Expose
  var listSlide : ArrayList<SlideAdverDto>? = null
  @SerializedName("listCart")
  @Expose
  var listCart : ArrayList<CartRestaurantDto>? = null
  @SerializedName("moreRestaurant")
  @Expose
  var moreRestaurant : ArrayList<RestaurantDto>? = null
}


class ListNotification {
  @SerializedName("listNotification")
  @Expose
  var listNotification : ArrayList<NotificationDto>? = null
}

interface IList {
  @GET("homescreen")
  fun Homescreen(): Call<Result<ListTab>>
  @GET("discover")
  fun Discover(): Call<Result<ListTab>>
  @GET("notification")
  fun Notification(): Call<Result<ListNotification>>
  @GET("restaurant")
  fun Restaurant(): Call<Result<ListTab>>
  @GET("cart")
  fun getCart(): Call<Result<ListTab>>
}

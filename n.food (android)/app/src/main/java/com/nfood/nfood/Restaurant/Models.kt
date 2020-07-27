package com.nfood.nfood.Restaurant

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RestaurantDto {
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  @SerializedName("restaurantAddress")
  @Expose
  var restaurantAddress: String? = null
  @SerializedName("ratedNumber")
  @Expose
  var ratedNumber: Double? = null
  @SerializedName("isVerify")
  @Expose
  var isVerify : Boolean = false
  @SerializedName("restaurantImage")
  @Expose
  var restaurantImage: String? = null
}

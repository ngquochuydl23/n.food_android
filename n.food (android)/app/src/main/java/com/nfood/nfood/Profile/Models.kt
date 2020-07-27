package com.nfood.nfood.Profile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nfood.nfood.Cart.OrderRestaurantDto
import com.nfood.nfood.Homescreen.RestaurantOrderDto
import java.io.Serializable

class AddressDto : Serializable {
  @SerializedName("userName")
  @Expose
  var userName: String? = null
  @SerializedName("userPhone")
  @Expose
  var userPhone: String? = null
  @SerializedName("userAddress")
  @Expose
  var userAddress: String? = null
  @SerializedName("ward")
  @Expose
  var ward: String? = null
  @SerializedName("district")
  @Expose
  var district: String? = null
  @SerializedName("city")
  @Expose
  var city: String? = null
  @SerializedName("addressDefault")
  @Expose
  var addressDefault: Boolean? = null
}


class PuschasesRestaurantDto {
  @SerializedName("idOrder")
  @Expose
  var idOrder: String? = null
  @SerializedName("deliveryStatus")
  @Expose
  var deliveryStatus: String? = null
  @SerializedName("date")
  @Expose
  var date: String? = null
  @SerializedName("listOrderRestaurant")
  @Expose
  var listOrderRestaurant: ArrayList<RestaurantOrderDto>? = null
}

class VoucherDto {
  @SerializedName("voucherImage")
  @Expose
  var voucherImage: String? = null
  @SerializedName("voucherStatus")
  @Expose
  var voucherStatus: String? = null
}
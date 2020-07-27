package com.nfood.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemProductDto {
    @SerializedName("productName")
  @Expose
  var productName: String? = null
  @SerializedName("productDiscount")
  @Expose
  var productDiscount: String? = null
  @SerializedName("restaurantName")
  @Expose
  var restaurantName: String? = null
  @SerializedName("productImage")
  @Expose
  var productImage: String? = null
}
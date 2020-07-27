package com.nfood.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMenuChildDto {
  @SerializedName("productName")
  @Expose
  var productName: String? = null
  @SerializedName("isSoldOut")
  @Expose
  var isSoldOut: Boolean? = null
  @SerializedName("productPrice")
  @Expose
  var productPrice: String? = null
  @SerializedName("productImage")
  @Expose
  var productImage: String? = null
}
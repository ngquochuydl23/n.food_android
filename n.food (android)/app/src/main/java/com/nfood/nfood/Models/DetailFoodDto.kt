package com.nfood.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DetailFoodDto {
  @SerializedName("title")
  @Expose
  var title: String? = null
  @SerializedName("image")
  @Expose
  var image: String? = null
  @SerializedName("listOption")
  @Expose
  var listOption: String? = null
}
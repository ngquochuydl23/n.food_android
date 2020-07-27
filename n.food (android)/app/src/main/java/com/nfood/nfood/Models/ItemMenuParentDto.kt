package com.nfood.nfood.Models
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMenuParentDto {
  @SerializedName("menuTitle")
  @Expose
  var menuTitle: String? = null
  @SerializedName("listMenuChild")
  @Expose
  var listMenuChild: ArrayList<ItemMenuChildDto>? = null
}

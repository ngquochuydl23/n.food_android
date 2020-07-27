package com.nfood.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemOption {
  @SerializedName("optionTitle")
  @Expose
  var optionTitle: String? = null
  @SerializedName("optionSubtitle")
  @Expose
  var optionSubtitle: String? = null
  @SerializedName("listChecked")
  @Expose
  var listChecked: ArrayList<ItemCheckedRadio>? = null
}

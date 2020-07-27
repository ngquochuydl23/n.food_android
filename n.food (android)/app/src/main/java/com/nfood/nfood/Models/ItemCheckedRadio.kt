package com.nfood.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemCheckedRadio {
  @SerializedName("checkedTitle")
  @Expose
  var checkedTitle: String? = null
  @SerializedName("checkedBonus")
  @Expose
  var checkedBonus: String? = null
  @SerializedName("checkRadio")
  @Expose
  var checkRadio: Boolean? = null
}

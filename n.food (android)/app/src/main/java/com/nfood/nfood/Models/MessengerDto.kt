package com.nfood.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MessengerDto {
  @SerializedName("id")
  @Expose
  var id : String? = null
  @SerializedName("name")
  @Expose
  var name : String? = null
  @SerializedName("avatar")
  @Expose
  var avatar : String? = null
  @SerializedName("time")
  @Expose
  var time : String? = null
  @SerializedName("statusMessenger")
  @Expose
  var statusMessenger : String? = null
  @SerializedName("isFromDriver")
  @Expose
  var isFromDriver : Boolean? = null
  @SerializedName("contentMessenger")
  @Expose
  var contentMessenger : String? = null
}
package com.nfood.nfood.Notification

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NotificationDto {
  @SerializedName("title")
  @Expose
  var title: String? = null
  @SerializedName("subTitle")
  @Expose
  var subTitle: String? = null
  @SerializedName("time")
  @Expose
  var time: String? = null
  @SerializedName("avatar")
  @Expose
  var avatar: String? = null
}
package com.nfood.nfood.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemCommentDto {
  @SerializedName("avatarUser")
  @Expose
  var avatarUser: String? = null
  @SerializedName("nameUser")
  @Expose
  var nameUser: String? = null
  @SerializedName("timePost")
  @Expose
  var timePost: String? = null
  @SerializedName("ratedUser")
  @Expose
  var ratedUser: Float? = null
  @SerializedName("descriptionComment")
  @Expose
  var descriptionComment: String? = null
}

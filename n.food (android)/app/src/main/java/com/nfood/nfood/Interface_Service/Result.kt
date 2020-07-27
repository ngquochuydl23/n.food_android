package com.nfood.nfood.Interface_Service

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result<T> {
  @SerializedName("result")
  @Expose
  var result: T? = null
  @SerializedName("statusCode")
  @Expose
  var statusCode: Int? = null
  @SerializedName("error")
  @Expose
  var error: Error? = null

  class Error{
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("password")
    @Expose
    var password : String? = null
  }
}
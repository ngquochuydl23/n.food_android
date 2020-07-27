package com.nfood.nfood.Interface_Service

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import java.io.Serializable

interface IProfile {
  @GET("profile")
  fun getProfile(): Call<Result<ProfileOutputDto>>
}

class ProfileOutputDto{
  @SerializedName("avatar")
  @Expose
  var avatarUser : String? = null
  @SerializedName("name")
  @Expose
  var nameUser : String? = null
  @SerializedName("email")
  @Expose
  var email : String? = null
  @SerializedName("phoneNumber")
  @Expose
  var phoneNumber : String? = null
  @SerializedName("address")
  @Expose
  var address : String? = null
}


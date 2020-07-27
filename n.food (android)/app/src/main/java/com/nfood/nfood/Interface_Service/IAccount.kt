package com.nfood.nfood.Interface_Service


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nfood.nfood.Register.*
import retrofit2.Call
import retrofit2.http.*


class AccountResult {
  @SerializedName("authToken")
  @Expose
  var authToken: String? = null
  @SerializedName("message")
  @Expose
  var message: String? = null
  @SerializedName("resendTime")
  @Expose
  var resendTime: Int? = null
}

interface IAccount {
  @POST("Account/SignIn/Google")
  fun signInWithFacebook(@Body input: LoginWithFacebookDto): Call<Result<LoginResultDto>>
  @POST("Account/SignIn/Google")
  fun signInWithGoogle(@Body input: LoginWithGoogleDto): Call<Result<LoginResultDto>>
  @POST("Account/SignIn")
  fun signIn(@Body input: LoginDto): Call<Result<LoginResultDto>>
  @POST("Account/SignUp")
  fun signUp(@Body input: SignUpDto): Call<Result<LoginResultDto>>
  @PUT("Account/UpdatePassword")
  fun updatePassword(@Body input: UpdatePasswordDto,@Header("Authorization") token : String): Call<Result<LoginResultDto>>
}


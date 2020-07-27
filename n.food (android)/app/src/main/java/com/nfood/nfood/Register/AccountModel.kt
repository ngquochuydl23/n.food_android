package com.nfood.nfood.Register

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VertificationCodeDto(val Code: String)

data class LoginWithGoogleDto(val AccessToken: String)

data class LoginWithFacebookDto(val AccessToken : String)

data class LoginDto(val Email: String,val Password : String,val IsPersistent : Boolean)

data class UpdatePasswordDto(val Password: String,val NewPassword : String,val ConfirmNewPassword : String)

data class SignUpDto(val PhoneNumber: String,val Email : String,val Password : String,val FullName : String)

data class ForgotPassworDto(val username: String)

class LoginResultDto{
  @SerializedName("authToken")
  @Expose
  var authToken : String? = null
}






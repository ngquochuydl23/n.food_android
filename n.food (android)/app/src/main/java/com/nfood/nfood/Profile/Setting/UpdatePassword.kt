package com.nfood.nfood.Profile.Setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.CallbackManager
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.BaseCallBack
import com.nfood.nfood.CustomDialog.LoadingDialog
import com.nfood.nfood.HttpClient
import com.nfood.nfood.Interface_Service.IAccount
import com.nfood.nfood.Interface_Service.Result
import com.nfood.nfood.R
import com.nfood.nfood.Register.LoginResultDto
import com.nfood.nfood.Register.*
import com.nfood.nfood.SaveToken
import kotlinx.android.synthetic.main.activity_update_password.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UpdatePassword : BaseActivity(), HttpClient, BaseCallBack<LoginResultDto> {

  var currentPassword : String = ""
  var newPassword : String = ""
  var confirmNewPassword : String = ""

  lateinit var callbackManager: CallbackManager
  lateinit var service: IAccount
  lateinit var loadingDialog : LoadingDialog
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_update_password)
    getActionBar(header,title.toString())

    callbackManager = CallbackManager.Factory.create()
    service = retrofit().create(IAccount::class.java)
    loadingDialog = LoadingDialog(this)

    saveChangeClick.setOnClickListener {
      loadingDialog.apply {
        onBlindDialog()
        showDialog()
      }
      updateYourPassword()
    }
  }

  private fun updateYourPassword(){
    currentPassword = enterCurrentPassword.text.toString()
    newPassword = enterNewPassword.text.toString()
    confirmNewPassword = enterConfirmPassword.text.toString()
    val token = SaveToken(this).getData()
    Log.d("token123",token)
    val httpClient1: OkHttpClient.Builder = OkHttpClient.Builder()
    val retrofit1: Retrofit = Retrofit.Builder()
      .baseUrl("http://demo-mobile-api.vastbit.com/api/")
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
      .client(httpClient1.build())
      .build()
    val server1 = retrofit1.create(IAccount::class.java)
    val call =
      server1.updatePassword(
        UpdatePasswordDto(currentPassword, newPassword,confirmNewPassword),
        "Bearer ${token}"
      )
    call.enqueue(this)
  }

  override fun onResponse(call: Call<Result<LoginResultDto>>, response: Response<Result<LoginResultDto>>) {
    super.onResponse(call, response)
    if(response.isSuccessful){
      val authToken = response.body()!!.result!!.authToken
      loadingDialog.dismiss()
      onCompleted(authToken!!)
    }
  }

  override fun onFailure(call: Call<Result<LoginResultDto>>, t: Throwable) {
    super.onFailure(call, t)
    loadingDialog.dismiss()
  }

  private fun onCompleted(authToken : String){
    Log.d("newAuthToken",authToken)
    SaveToken(this).setData(authToken)
    finish()
  }
}

package com.nfood.nfood.Register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.facebook.CallbackManager
import com.nfood.nfood.*
import com.nfood.nfood.Homescreen.Homescreen
import com.nfood.nfood.Interface_Service.IAccount
import com.nfood.nfood.Interface_Service.ProfileOutputDto
import com.nfood.nfood.Interface_Service.Result
import kotlinx.android.synthetic.main.fragment_sign_up.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SignUp : Fragment(), HttpClient, BaseCallBack<LoginResultDto> {

  var username: String = ""
  var fullname: String = ""
  var phoneNumber: String = ""
  var password: String = ""

  lateinit var callbackManager: CallbackManager
  lateinit var service: IAccount

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_sign_up, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    callbackManager = CallbackManager.Factory.create()
    service = retrofit().create(IAccount::class.java)
    signUpClick.setOnClickListener {
      signUp()
    }
  }

  private fun signUp() {
    username = enterUsername.text.toString()
    fullname = enterFullname.text.toString()
    phoneNumber = enterPhoneNumber.text.toString()
    password = enterPassword.text.toString()
    if (username.isEmpty())
      errorUsername.text = "Please enter username"
    if (fullname.isEmpty())
      errorFullname.text = "Please enter fullname"
    if (phoneNumber.isEmpty())
      errorPhoneNumber.text = "Please enter phone number"
    if (password.isEmpty())
      errorPassword.text = "Please enter password"
    else {
      val httpClient1: OkHttpClient.Builder = OkHttpClient.Builder()
      val retrofit1: Retrofit = Retrofit.Builder()
        .baseUrl("http://demo-mobile-api.vastbit.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(httpClient1.build())
        .build()
      val server1 = retrofit1.create(IAccount::class.java)
      val call =
        server1.signUp(SignUpDto(phoneNumber, username, password, fullname))
      call.enqueue(this)
    }
    onChangeText(enterUsername, errorUsername)
    onChangeText(enterPassword, errorPassword)
    onChangeText(enterFullname, errorFullname)
    onChangeText(enterPhoneNumber, errorPhoneNumber)

  }

  override fun onResponse(
    call: Call<Result<LoginResultDto>>,
    response: Response<Result<LoginResultDto>>
  ) {
    super.onResponse(call, response)
    if (response.isSuccessful) {
      val authToken = response.body()!!.result!!.authToken
      onCompleted(authToken!!)
    }
  }

  override fun onFailure(call: Call<Result<LoginResultDto>>, t: Throwable) {
    super.onFailure(call, t)
  }

  private fun onCompleted(authToken: String) {
    var user = ProfileOutputDto()
    user.nameUser = "Ngọc Vân"
    user.avatarUser =
      "https://scontent-hkg4-1.xx.fbcdn.net/v/t1.15752-9/93860343_2346686558961766_2416565144390729728_n.jpg?_nc_cat=109&_nc_sid=b96e70&_nc_ohc=Q21S0l4zBWUAX_jegF6&_nc_ht=scontent-hkg4-1.xx&oh=cac2d2502ab3896d782103701a72bd4b&oe=5EF2466F"
    user.email = "ngocvan@gmail.com"
    user.phoneNumber = "0938288768"
    user.address = "59 Xô Viết Nghệ Tỉnh, P7, Đà Lạt"
    SaveUserInformation(context).setData(user)

    SaveToken(context).setData(authToken)
    val intent = Intent(context, Homescreen::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    activity!!.finish()
  }

  private fun onChangeText(text: TextView, textError: TextView) {
    text.addTextChangedListener(object : TextWatcher {
      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        textError.text = null
      }

      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
      override fun afterTextChanged(s: Editable?) {}
    })
  }
}

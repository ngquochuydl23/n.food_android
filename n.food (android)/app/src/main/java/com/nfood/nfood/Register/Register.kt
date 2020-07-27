package com.nfood.nfood.Register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.nfood.nfood.*
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Homescreen.Homescreen
import com.nfood.nfood.Interface_Service.IAccount
import com.nfood.nfood.Interface_Service.ProfileOutputDto
import com.nfood.nfood.Interface_Service.Result
import kotlinx.android.synthetic.main.activity_regiter.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class Register : BaseActivity(), HttpClient, BaseCallBack<LoginResultDto> {

  private val GOOGLE_LOGIN = 0
  private val FACEBOOK_LOGIN = -1

  var username: String = ""
  var password: String = ""

  lateinit var callbackManager: CallbackManager
  lateinit var service: IAccount

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_regiter)
    callbackManager = CallbackManager.Factory.create()
    service = retrofit().create(IAccount::class.java)
    login.setOnClickListener {
      loginWithUserName()
    }
    googleClick.setOnClickListener {
      googleLogin.performClick()
      getAccessTokenGoogle()
    }
    facebookClick.setOnClickListener {
      facebookLogin.performClick()
      getAccessTokenFacebook()
    }
    signUpClick.setOnClickListener {
      addFragment(SignUp(),"SignUpFragmentTag")
    }
  }

  private fun loginWithUserName() {
    username = enterUsername.text.toString()
    password = enterPassword.text.toString()
    if (username.isEmpty())
      errorUsername.text = "Please enter username"
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
        server1.signIn(LoginDto(username, password,true))
      call.enqueue(this)
    }
    onChangeText(enterUsername, errorUsername)
    onChangeText(enterPassword, errorPassword)
  }

  private fun loginWithFacebook(accessToken: String) {
    val call = service.signInWithFacebook(LoginWithFacebookDto(accessToken))
    call.enqueue(this)
  }

  private fun loginWithGoogle(accessToken: String?) {
    onCompleted(accessToken)
  }

  private fun getAccessTokenGoogle() {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
      .requestIdToken(getString(R.string.server_client_id))
      .requestEmail()
      .build()
    val googleSignInClient = GoogleSignIn.getClient(this, gso)
    val signInIntent = googleSignInClient.signInIntent
    startActivityForResult(signInIntent, 0)
  }

  private fun getAccessTokenFacebook() {
    facebookLogin.setReadPermissions("email")
    facebookLogin.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
      override fun onSuccess(result: LoginResult?) {
        val accessToken = result!!.accessToken.token
        Log.d("AccessTokenFacebook", accessToken)
        //loginWithFacebook(accessToken)
      }

      override fun onCancel() {}

      override fun onError(error: FacebookException?) {}
    })
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    when (resultCode) {
      FACEBOOK_LOGIN -> callbackManager.onActivityResult(requestCode, resultCode, data)
      GOOGLE_LOGIN -> {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
          val account = task.getResult(ApiException::class.java)!!
          Log.d("firebaseAuthWithGoogle", ":" + account)
          loginWithGoogle(account.idToken)
        } catch (e: ApiException) {
          Log.e("googleLoginError", e.toString())
        }
      }
    }
  }

  override fun onResponse(call: Call<Result<LoginResultDto>>, response: Response<Result<LoginResultDto>>) {
    Log.d("statusCode", response.code().toString())
    if (response.isSuccessful) {
      val authToken = response.body()!!.result!!.authToken
      Log.d("AuthToken", authToken)
      onCompleted(authToken)
    } else if(response.code() ==  400){
      val error = response.message()
      Log.d("error", error)
    }
  }

  override fun onFailure(call: Call<Result<LoginResultDto>>, t: Throwable) {
    t.printStackTrace()
  }

  private fun onCompleted(AuthToken: String?) {
      var user = ProfileOutputDto()
      user.nameUser = "Vũ Hoàng Uyên Nhi"
      user.avatarUser = "https://scontent.fdad3-2.fna.fbcdn.net/v/t1.15752-9/109130389_302213754562306_7581060118246688369_n.jpg?_nc_cat=105&_nc_sid=b96e70&_nc_ohc=5vcuc2rSSxcAX-wONp9&_nc_ht=scontent.fdad3-2.fna&oh=4e04828c4a5026d01f859cf346fd40d0&oe=5F30F9AC"
      user.email = "uyennhivuhoang@gmail.com"
      user.phoneNumber = "0917833891"
      user.address = "59 Xô Viết Nghệ Tỉnh, P7, Đà Lạt"
      SaveUserInformation(this).setData(user)

    SaveToken(this@Register).setData(AuthToken)
    val intent = Intent(this, Homescreen::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    finish()
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

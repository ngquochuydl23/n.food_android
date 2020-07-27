package com.nfood.nfood

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.core.content.ContextCompat.getSystemService
import com.nfood.nfood.Interface_Service.Result
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


interface HttpClient {
  fun retrofit(): Retrofit {
    val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
    val retrofit: Retrofit = Retrofit.Builder()
      .baseUrl("http://vemaybay.vastbit.com/nfood-api/")
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
      .client(httpClient.build())
      .build()
    return retrofit
  }

}
interface BaseCallBack<T> : Callback<Result<T>> {

  override fun onResponse(call: Call<Result<T>>, response: Response<Result<T>>) {
    val statusCode = response.code()
    Log.d("statusCode",statusCode.toString())
  }
  override fun onFailure(call: Call<Result<T>>, t: Throwable) {
    t.printStackTrace()
  }
}


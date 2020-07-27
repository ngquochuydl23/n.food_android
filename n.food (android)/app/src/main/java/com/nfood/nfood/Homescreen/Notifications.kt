package com.nfood.nfood.Homescreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.NotificationAdapter
import com.nfood.nfood.Base.BaseFragment
import com.nfood.nfood.BaseCallBack
import com.nfood.nfood.Interface_Service.IList
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_notifications.*
import retrofit2.Call
import retrofit2.Response
import com.nfood.nfood.HttpClient
import com.nfood.nfood.Interface_Service.*
import com.nfood.nfood.Notification.NotificationDto
import kotlinx.android.synthetic.main.fragment_notifications.header
import retrofit2.http.GET


interface INotification{
  @GET("notification")
  fun getListNotification(): Call<Result<ListNotification>>
}

class Notifications : BaseFragment(),HttpClient, BaseCallBack<ListNotification> {

  lateinit var service: INotification
  lateinit var call: Call<Result<ListNotification>>

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_notifications, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    header.text = getString(R.string.notification)
    progressBar.visibility = View.VISIBLE
    getListNotification()
  }

  private fun getListNotification(){
    service = retrofit().create(INotification::class.java)
    call = service.getListNotification()
    listNotification.layoutManager = LinearLayoutManager(context)
    call.enqueue(this)
  }

  override fun onResponse(call: Call<Result<ListNotification>>, response: Response<Result<ListNotification>>) {
    super.onResponse(call, response)
    if(response.isSuccessful){
      progressBar.visibility = View.GONE
      val list = response.body()!!.result!!.listNotification
      Log.d("noti",list.toString())
      listNotification.adapter = NotificationAdapter(list)
    }
  }

  override fun onFailure(call: Call<Result<ListNotification>>, t: Throwable) {
    super.onFailure(call, t)
    progressBar.visibility = View.GONE
  }
}

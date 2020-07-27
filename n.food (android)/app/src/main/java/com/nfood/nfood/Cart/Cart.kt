package com.nfood.nfood.Cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.CartRestaurantAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.BaseCallBack
import com.nfood.nfood.HttpClient
import com.nfood.nfood.Interface_Service.ListTab
import com.nfood.nfood.Interface_Service.Result
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_cart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

interface ICart {
  @GET("cart")
  fun getCart(): Call<Result<ListTab>>
}

class Cart : BaseActivity(), HttpClient, BaseCallBack<ListTab> {

  lateinit var service: ICart
  lateinit var call: Call<Result<ListTab>>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cart)
    getActionBar(header, getString(R.string.cart))
    recyclerView.layoutManager = LinearLayoutManager(this@Cart)
    checkout_button.setOnClickListener {
      val intent = Intent(this, CheckOut::class.java)
      startActivity(intent)
    }
    recyclerView.layoutManager = LinearLayoutManager(this)
    service = retrofit().create(ICart::class.java)
    call = service.getCart()
    call.enqueue(this)
  }

  override fun onResponse(call: Call<Result<ListTab>>, response: Response<Result<ListTab>>) {
    super.onResponse(call, response)
    if (response.isSuccessful) {
      progressBar.visibility = View.GONE
      val listCart = response.body()!!.result!!.listCart!!
      if (listCart.isNotEmpty()) {
        layout_order.visibility = View.VISIBLE
        recyclerView.adapter = CartRestaurantAdapter(listCart)
      }
    }
  }

  override fun onFailure(call: Call<Result<ListTab>>, t: Throwable) {
    super.onFailure(call, t)
    progressBar.visibility = View.GONE
  }
}

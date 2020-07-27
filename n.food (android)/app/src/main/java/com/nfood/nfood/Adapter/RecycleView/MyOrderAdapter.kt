package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Cart.Cart
import com.nfood.nfood.Cart.CheckOut
import com.nfood.nfood.Profile.MyPurchases.OrderDetail
import com.nfood.nfood.Profile.PuschasesRestaurantDto
import com.nfood.nfood.R
import com.nfood.nfood.Rate.RateDriver

class MyOrderAdapter(val list : ArrayList<PuschasesRestaurantDto>) : BaseRecycleViewAdapter(){

  private var ON_GOING = "OnGoing"
  private var COMPLETED = "Completed"

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    return MyOrderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_my_order, parent, false))
  }
  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val listPurchasesOrder = list[position]
    val viewHolder: MyOrderViewHolder = holder as MyOrderViewHolder
    viewHolder.idOrder.text = listPurchasesOrder.idOrder
    viewHolder.date.text = listPurchasesOrder.date
    viewHolder.deliveryStatus.text = listPurchasesOrder.deliveryStatus
    viewHolder.thumbnailClick.setOnClickListener {
      val intent = Intent(context, OrderDetail::class.java)
      context!!.startActivity(intent)
    }
    if(listPurchasesOrder.listOrderRestaurant!!.size < 2)
      viewHolder.seeMore.visibility = View.GONE
    Log.d("1",listPurchasesOrder.listOrderRestaurant!!.toString())
    viewHolder.listOrderRestaurant.layoutManager = LinearLayoutManager(context)
    viewHolder.listOrderRestaurant.adapter = OrderRestaurantAdapter(listPurchasesOrder.listOrderRestaurant!!)
    viewHolder.rateClick.setOnClickListener {
      val intent = Intent(context,RateDriver::class.java)
      context!!.startActivity(intent)
    }
    viewHolder.reOrderClick.setOnClickListener {
      val intent = Intent(context,Cart::class.java)
      context!!.startActivity(intent)
    }

  }
}
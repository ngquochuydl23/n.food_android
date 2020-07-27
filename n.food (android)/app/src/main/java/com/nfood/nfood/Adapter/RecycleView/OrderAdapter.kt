package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Cart.OrderRestaurantDto
import com.nfood.nfood.R


class OrderAdapter(val listOrder : ArrayList<OrderRestaurantDto>) : BaseRecycleViewAdapter(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false)
    return OrderViewHolder(view)
  }

  override fun getItemCount(): Int {
    if(listOrder != null && listOrder!!.isNotEmpty()){
      return listOrder!!.size
    }
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if(listOrder != null && listOrder!!.isNotEmpty()){
      val order  = listOrder!![position]
      //restaurant
      val viewHolder: OrderViewHolder = holder as OrderViewHolder
      viewHolder.restaurantName.text = order.restaurantName
      viewHolder.listOrderItem.apply {
        isNestedScrollingEnabled = false
        layoutManager = object : LinearLayoutManager(holder.listOrderItem.context, RecyclerView.VERTICAL, false) {
          override fun canScrollVertically(): Boolean = false
        }
        adapter = object : OrderItemAdapter(order.listOrder){
          override fun onClick() { return }
        }
      }

    }
  }

}
package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Homescreen.RestaurantOrderDto
import com.nfood.nfood.R


class OrderRestaurantAdapter(val list : ArrayList<RestaurantOrderDto>)  : BaseRecycleViewAdapter(){
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    return MyOrderRestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_order_restaurant, parent, false))
  }

  override fun getItemCount(): Int {
    return list.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val listOrderRestaurant = list[position]
    val viewHolder: MyOrderRestaurantViewHolder = holder as MyOrderRestaurantViewHolder
    viewHolder.restaurantName.text = listOrderRestaurant.restaurantName
    viewHolder.restaurantAddress.text = listOrderRestaurant.restaurantAddress
    viewHolder.restaurantCash.text = listOrderRestaurant.restaurantCash
    Application(context!!).setImage(viewHolder.restaurantImage,listOrderRestaurant.restaurantImage)
  }

}
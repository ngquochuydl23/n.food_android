package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Homescreen.CartRestaurantDto
import com.nfood.nfood.R
import com.nfood.nfood.Restaurant.Restaurant

class CartRestaurantAdapter(val list : ArrayList<CartRestaurantDto>) : BaseRecycleViewAdapter(){
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    return CartRestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cart_restaurant, parent, false))
  }
  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val item = list[position]
    val viewHolder: CartRestaurantViewHolder = holder as CartRestaurantViewHolder
    val productList = item.listProduct
    viewHolder.restaurantName.apply {
      text = item.restaurantName
      setOnClickListener {
        val intent = Intent(context,Restaurant::class.java)
        context.startActivity(intent)
      }
    }
    viewHolder.listProduct.apply {
      isNestedScrollingEnabled = false
      layoutManager = object : LinearLayoutManager(holder.listProduct.context, RecyclerView.VERTICAL, false) {
        override fun canScrollVertically(): Boolean = false
      }
      adapter = CartProductAdapter(productList)
    }
  }
}
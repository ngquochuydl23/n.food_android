package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Layout
import com.nfood.nfood.R
import com.nfood.nfood.Restaurant.Restaurant
import com.nfood.nfood.Restaurant.RestaurantDto

class RestaurantAdapter() : BaseRecycleViewAdapter() {

  private var List : ArrayList<RestaurantDto> = arrayListOf()
  private var typeLayout : String? = Layout().vertical

  constructor(List:  ArrayList<RestaurantDto>?): this() {
    this.List = List!!
  }

  constructor(List:  ArrayList<RestaurantDto>?,typeLayout : String?): this() {
    this.List = List!!
    this.typeLayout = typeLayout
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    if(typeLayout == Layout().vertical)
      return RestaurantViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant_verti, parent, false))
    return RestaurantViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant_hori, parent, false))
  }

  override fun getItemCount(): Int {
    if (List != null)
      return List.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (List != null && List.isNotEmpty()) {
      val item = List[position]
      val viewHolder: RestaurantViewHolder = holder as RestaurantViewHolder

      viewHolder.restaurantName.text = item.restaurantName
      viewHolder.restaurantAddress.text = item.restaurantAddress
      if (!item.isVerify && item.isVerify != null)
        viewHolder.isVerify.visibility = View.GONE
      if (item.ratedNumber != 0.0 && item.ratedNumber != null)
        viewHolder.ratedNumber.apply {
          visibility = View.VISIBLE
          text = item.ratedNumber.toString()
        }
      else viewHolder.ratedNumber.visibility = View.INVISIBLE

      Application(context!!).setImage(viewHolder.restaurantImage,item.restaurantImage)
      viewHolder.thumbnailClick.setOnClickListener {
        val intent = Intent(context,Restaurant::class.java)
        context!!.startActivity(intent)
      }
    }
  }
}
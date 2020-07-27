package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Base.BaseActivity

import com.nfood.nfood.Homescreen.SearchResultDto
import com.nfood.nfood.R
import com.nfood.nfood.Restaurant.RestaurantDto

class SearchResultAdapter() : BaseRecycleViewAdapter(){

  var listSearchResult : ArrayList<SearchResultDto>? = null

  constructor(listSearchResult : ArrayList<SearchResultDto>?): this(){
    this.listSearchResult = listSearchResult
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_search_result, parent, false)
    return SearchResultViewHolder(view)
  }

  override fun getItemCount(): Int {
    if(listSearchResult != null && listSearchResult!!.isNotEmpty()){
      return listSearchResult!!.size
    }
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if(listSearchResult != null && listSearchResult!!.isNotEmpty()){
      val item  = listSearchResult!![position]
      val restaurant = item.restaurant
      val listProduct  = item.listProduct
      //restaurant
      val viewHolder: SearchResultViewHolder = holder as SearchResultViewHolder

      viewHolder.restaurantName.text = restaurant!!.restaurantName
      viewHolder.restaurantAddress.text = restaurant!!.restaurantAddress
      viewHolder.ratedNumber.text = restaurant!!.ratedNumber.toString()
      if(restaurant.isVerify)
        viewHolder.isVerify.visibility = View.GONE
      Application(context!!).setImage(viewHolder.restaurantImage,restaurant!!.restaurantImage)
      //listProduct
    }
  }
}
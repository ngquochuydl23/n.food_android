package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Homescreen.ViewMore
import com.nfood.nfood.Interface_Service.Tab
import com.nfood.nfood.Layout
import com.nfood.nfood.R

class ListTabAdapter(val list : ArrayList<Tab>) : BaseRecycleViewAdapter(){

  private var viewPool = RecyclerView.RecycledViewPool()


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tab, parent, false)
    return TabViewHolder(view)
  }
  override fun getItemCount(): Int {
    if(list != null && list.isNotEmpty()){
      return list.size
    }
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val tab = list[position]
    val viewHolder: TabViewHolder = holder as TabViewHolder
    val typeList = tab.list
    val type = tab.type
    viewHolder.title.text = tab.title
    if(type == Layout().vertical)
      viewHolder.listTab.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    else if (type == Layout().horizontal)
      viewHolder.listTab.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    else if (type == Layout().grid)
      viewHolder.listTab.layoutManager = GridLayoutManager(context, 2,RecyclerView.VERTICAL,false)
    viewHolder.listTab.apply {
      when (typeList) {
        "restaurantList" -> {
          val listRestaurant = tab.restaurantList!!
          adapter = RestaurantAdapter(listRestaurant,type)
          setRecycledViewPool(viewPool)
        }
        "productList" -> {
          val listFood = tab.productList!!
          adapter = ProductAdapter(listFood,type)
          setRecycledViewPool(viewPool)
        }
      }
    }
    viewHolder.seeAll.setOnClickListener {
      val intent = Intent(context, ViewMore::class.java)
      intent.putExtra("Title",tab.title)
      context!!.startActivity(intent)
    }
  }

}
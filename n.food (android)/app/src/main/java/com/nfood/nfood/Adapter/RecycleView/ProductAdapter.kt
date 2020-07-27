package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Food.DetailFood
import com.nfood.nfood.Layout
import com.nfood.nfood.Models.ItemProductDto
import com.nfood.nfood.R
import com.nfood.nfood.Restaurant.Restaurant

class ProductAdapter() : BaseRecycleViewAdapter() {

  private var List : ArrayList<ItemProductDto> = arrayListOf()
  private var typeLayout : String? = Layout().vertical

  constructor(List: ArrayList<ItemProductDto>?): this() {
    this.List = List!!
  }

  constructor(List: ArrayList<ItemProductDto>?,typeLayout : String?): this() {
    this.List = List!!
    this.typeLayout = typeLayout
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
//    if(typeLayout == Layout().vertical)
//      return ItemMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu_verti, parent, false))
//    else {
//      val view = ItemMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu_grid, parent, false))
//      return view
//    }
    return ItemProductViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product, parent, false))
  }
  override fun getItemCount(): Int {
    if (List != null)
      return List.size
    return 0
  }
  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (List != null && List.isNotEmpty()) {
      val item = List[position]
      val viewHolder: ItemProductViewHolder = holder as ItemProductViewHolder
      viewHolder.productName.text = item.productName
      viewHolder.productDiscount.text = item.productDiscount
      viewHolder.restaurantName.text = item.restaurantName
      Application(context!!).setImage(viewHolder.productImage, item.productImage)
      viewHolder.thumbnailClick.setOnClickListener {

        val intentRestaurant = Intent(context,Restaurant::class.java)
        context!!.startActivity(intentRestaurant)
        val intentDetailFood = Intent(context,DetailFood::class.java)
        context!!.startActivity(intentDetailFood)
      }
    }
  }
  class ItemProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val productName = itemView.findViewById<TextView>(R.id.productName)
    val productDiscount = itemView.findViewById<TextView>(R.id.productDiscount)
    val restaurantName = itemView.findViewById<TextView>(R.id.restaurantName)
    val productImage = itemView.findViewById<ImageView>(R.id.productImage)
    val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
  }
}
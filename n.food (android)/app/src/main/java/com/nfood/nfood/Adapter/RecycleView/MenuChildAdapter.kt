package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.CustomDialog.SoldOutDialog
import com.nfood.nfood.Food.DetailFood
import com.nfood.nfood.Layout
import com.nfood.nfood.Models.ItemMenuChildDto
import com.nfood.nfood.R

class MenuChildAdapter() : BaseRecycleViewAdapter() {

  private var List : ArrayList<ItemMenuChildDto> = arrayListOf()
  private var typeLayout : String? = Layout().vertical

  constructor(List: ArrayList<ItemMenuChildDto>?): this() {
    this.List = List!!
  }

  constructor(List: ArrayList<ItemMenuChildDto>?, typeLayout : String?): this() {
    this.List = List!!
    this.typeLayout = typeLayout
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuChildViewHolder{
    context = parent.context
    if(typeLayout == Layout().vertical)
      return MenuChildViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu_child_verti, parent, false))
    else {
      val view = MenuChildViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu_child_grid, parent, false))
      return view
    }
  }
  override fun getItemCount(): Int {
    if (List != null)
      return List.size
    return 0
  }
  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (List != null && List.isNotEmpty()) {
      val item = List[position]
      val viewHolder = holder as MenuChildViewHolder
      viewHolder.productName.text = item.productName
      viewHolder.productPrice.text = item.productPrice
      if(item.isSoldOut!!)
        viewHolder.isSoldOut.visibility = View.VISIBLE
      Application(context!!).setImage(viewHolder.productImage, item.productImage)
      viewHolder.thumbnailClick.setOnClickListener {
        if(item.isSoldOut!!){
          var soldOutDialog = SoldOutDialog(context!!)
          soldOutDialog.getFoodName(item.productName!!)
          soldOutDialog.onBlindDialog()
          soldOutDialog.showDialog()
        } else {
          val intent = Intent(context,DetailFood::class.java)
          context!!.startActivity(intent)
        }
      }
    }
  }
  class MenuChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val productName = itemView.findViewById<TextView>(R.id.productName)
    val productPrice = itemView.findViewById<TextView>(R.id.productPrice)
    val isSoldOut = itemView.findViewById<View>(R.id.isSoldOut)
    val productImage = itemView.findViewById<ImageView>(R.id.productImage)
    val thumbnailClick = itemView.findViewById<View>(R.id.thumbnailClick)
  }
}
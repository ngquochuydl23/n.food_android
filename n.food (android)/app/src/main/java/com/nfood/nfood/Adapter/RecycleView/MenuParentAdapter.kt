package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Layout
import com.nfood.nfood.Models.ItemMenuParentDto
import com.nfood.nfood.R

class MenuParentAdapter() : BaseRecycleViewAdapter(){

  private var ListMenuParent : ArrayList<ItemMenuParentDto> = arrayListOf()
  private var typeLayout : String? = Layout().vertical

  constructor(List:  ArrayList<ItemMenuParentDto>?): this() {
    this.ListMenuParent = List!!
  }

  constructor(List : ArrayList<ItemMenuParentDto>?,typeLayout : String?): this() {
    this.ListMenuParent = List!!
    this.typeLayout = typeLayout
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater
      .from(parent.context)
      .inflate(R.layout.item_menu_parent, parent, false)
    return MenuParentViewHolder(view)
  }
  override fun getItemCount(): Int {
    if(ListMenuParent != null && ListMenuParent.isNotEmpty())
      return ListMenuParent.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val itemMenuParent = ListMenuParent[position]
    val viewHolder=  holder as MenuParentViewHolder
    viewHolder.menuTitle.text = itemMenuParent.menuTitle
    viewHolder.listMenuChild.apply {
      if(typeLayout == Layout().vertical)
        layoutManager = LinearLayoutManager(context)
      else layoutManager = GridLayoutManager(context,2)
    }
    viewHolder.listMenuChild.adapter = MenuChildAdapter(itemMenuParent.listMenuChild,typeLayout)
  }

  class MenuParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val menuTitle = itemView.findViewById<TextView>(R.id.menuTitle)
    val listMenuChild = itemView.findViewById<RecyclerView>(R.id.listMenuChild)
  }
}
package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Homescreen.CategoryDto
import com.nfood.nfood.Homescreen.ViewMore
import com.nfood.nfood.R

class CategoryAdapter(val list: ArrayList<CategoryDto>) : BaseRecycleViewAdapter() {
  private val bundle = Bundle()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
    return CategoryViewHolder(view)
  }

  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val item = list[position]
    val viewHolder: CategoryViewHolder = holder as CategoryViewHolder
    //onBlind
    viewHolder.title.text = item.title
    viewHolder.numberPlace.text = item.place
    Application(context!!).setImage(viewHolder.image, item.image)
    //onClick
    viewHolder.thumbnailClick.setOnClickListener {
      bundle.putString(Title,item.title)
      val intent = Intent(context, ViewMore::class.java)
      intent.putExtras(bundle)
      context!!.startActivity(intent)
    }
  }
  companion object {
    private val Title = "Title"
  }
}
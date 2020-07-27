package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Models.ItemCheckedRadio
import com.nfood.nfood.Models.ItemOption
import com.nfood.nfood.R

class OptionAdapter(val listItemOption : ArrayList<ItemOption>) : BaseRecycleViewAdapter() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_option, parent, false)
    return OptionViewHolder(view)
  }

  override fun getItemCount(): Int {
    if(listItemOption != null && listItemOption.isNotEmpty())
      return listItemOption.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (listItemOption != null && listItemOption.isNotEmpty()) {
      val itemOption = listItemOption[position]
      val viewHolder: OptionViewHolder = holder as OptionViewHolder
      viewHolder.optionTitle.text = itemOption.optionTitle
      viewHolder.optionSubtitle.text = itemOption.optionSubtitle
      viewHolder.listChecked.layoutManager = LinearLayoutManager(context)
      viewHolder.listChecked.adapter = CheckedAdapter(itemOption.listChecked!!)
    }
  }

  class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val optionTitle = itemView.findViewById<TextView>(R.id.optionTitle)
    val optionSubtitle = itemView.findViewById<TextView>(R.id.optionSubtitle)
    val listChecked = itemView.findViewById<RecyclerView>(R.id.listChecked)
  }
}
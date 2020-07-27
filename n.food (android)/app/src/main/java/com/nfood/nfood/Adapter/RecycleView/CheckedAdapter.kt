package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Models.ItemCheckedRadio
import com.nfood.nfood.R

class CheckedAdapter(val listItemChecked : ArrayList<ItemCheckedRadio>) : BaseRecycleViewAdapter() {

  private var result : String? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_checked_radio, parent, false)
    return CheckedItemViewHolder(view)
  }

  override fun getItemCount(): Int {
    if(listItemChecked != null && listItemChecked.isNotEmpty())
      return listItemChecked.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (listItemChecked != null && listItemChecked.isNotEmpty()) {
      val itemCheckRadio = listItemChecked[position]
      val viewHolder: CheckedItemViewHolder = holder as CheckedItemViewHolder
      viewHolder.checkedTitle.text = itemCheckRadio.checkedTitle
      viewHolder.checkedBonus.let {
        if(itemCheckRadio.checkedBonus == null){
          it.visibility = View.GONE
        } else it.text = "+ ${itemCheckRadio.checkedBonus}"
      }
      var check = itemCheckRadio.checkRadio!!
      viewHolder.itemCheckRadioClick.setOnClickListener {
        check = !check
        viewHolder.checkRadio.isChecked = check
        if(check){
          setTextColorSelected(viewHolder.checkedTitle)
          setTextColorSelected(viewHolder.checkedBonus)
        } else {
          setTextColorUnSelected(viewHolder.checkedTitle)
          setTextColorUnSelected(viewHolder.checkedBonus)
        }
      }
    }
  }

  private fun setTextColorSelected(textView: TextView){
    textView.setTextColor(ContextCompat.getColor(context!!, R.color.titleTextColor))
  }

  private fun setTextColorUnSelected(textView: TextView){
    textView.setTextColor(ContextCompat.getColor(context!!, R.color.textColorPrimary))
  }


  fun getResult(){

  }

  fun setResult(){

  }

  class CheckedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val checkedTitle = itemView.findViewById<TextView>(R.id.checkedTitle)
    val checkedBonus = itemView.findViewById<TextView>(R.id.checkedBonus)
    val checkRadio = itemView.findViewById<RadioButton>(R.id.checkRadio)
    val itemCheckRadioClick = itemView.findViewById<View>(R.id.itemCheckRadioClick)
  }
}
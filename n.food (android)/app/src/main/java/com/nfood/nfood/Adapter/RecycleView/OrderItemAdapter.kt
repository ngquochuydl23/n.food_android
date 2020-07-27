package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Food.DetailFood
import com.nfood.nfood.Homescreen.OrderProductDto
import com.nfood.nfood.R

open class OrderItemAdapter(val List: ArrayList<OrderProductDto>?) : BaseRecycleViewAdapter() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_product_order, parent, false)
    return PurchasesProductViewHolder(view)
  }

  override fun getItemCount(): Int {
    if (List != null)
      return List.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (List != null && List.isNotEmpty()) {
      val item = List[position]
      val viewHolder: PurchasesProductViewHolder = holder as PurchasesProductViewHolder

      viewHolder.productName.text = item.productName
      viewHolder.productNote.text = item.productNote
      viewHolder.productCost.text = item.productCost
      viewHolder.productNumber.text = "x${item.productNumber}"
      Application(context!!).setImage(viewHolder.productImage,item.productImage)

      viewHolder.thumbnailClick.setOnClickListener {
        onClick()
      }

    }

  }
  open fun onClick(){
    val intent = Intent(context, DetailFood::class.java)
    context!!.startActivity(intent)
  }

}
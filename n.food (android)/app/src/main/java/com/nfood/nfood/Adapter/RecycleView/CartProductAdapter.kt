package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Food.DetailFood
import com.nfood.nfood.Homescreen.OrderProductDto
import com.nfood.nfood.R

class CartProductAdapter(val List: ArrayList<OrderProductDto>?) : BaseRecycleViewAdapter() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_cart_product, parent, false)
    return CartProductViewHolder(view)
  }

  override fun getItemCount(): Int {
    if (List != null)
      return List.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (List != null && List.isNotEmpty()) {
      val item = List[position]
      val viewHolder: CartProductViewHolder = holder as CartProductViewHolder

      viewHolder.productName.text = item.productName
      viewHolder.productNote.text = item.productNote
      viewHolder.productCost.text = item.productCost
      viewHolder.productNumber.text = item.productNumber.toString()

      Application(context!!).setImage(viewHolder.productImage, item.productImage)
      viewHolder.thumbnailClick.setOnClickListener {
        val intent = Intent(context,DetailFood::class.java)
        context!!.startActivity(intent)
      }
      viewHolder.increaseClick.setOnClickListener {
        var numberProduct = item.productNumber!!
        if(numberProduct >= 1){
          numberProduct++
          viewHolder.productNumber.text = numberProduct.toString()
        }
      }
      viewHolder.decreaseClick.setOnClickListener {
        var numberProduct = item.productNumber!!
        if(numberProduct > 1){
          numberProduct--
          viewHolder.productNumber.text = numberProduct.toString()
        }
      }
      viewHolder.deleteClick.setOnClickListener {

      }
    }
  }
}
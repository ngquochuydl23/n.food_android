package com.nfood.nfood.Adapter.RecycleView

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Profile.MyVoucher.DetailVoucher
import com.nfood.nfood.Profile.VoucherDto
import com.nfood.nfood.R

open class VoucherAdapter(val list : ArrayList<VoucherDto>) : BaseRecycleViewAdapter(){
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    return VoucherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_voucher, parent, false))
  }
  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val item = list[position]
    val viewHolder: VoucherViewHolder = holder as VoucherViewHolder
    Application(context!!).setImage(viewHolder.voucherImage,item.voucherImage)
    viewHolder.thumbnailClick.setOnClickListener {
      voucherClick()
    }
  }
  open fun voucherClick(){
    val intent = Intent(context,DetailVoucher::class.java)
    context!!.startActivity(intent)
  }
}
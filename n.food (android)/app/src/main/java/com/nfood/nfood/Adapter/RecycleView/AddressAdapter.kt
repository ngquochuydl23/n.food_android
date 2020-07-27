package com.nfood.nfood.Adapter.RecycleView

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Profile.Address.AddEditAddress
import com.nfood.nfood.Profile.AddressDto
import com.nfood.nfood.R

open class AddressAdapter(val List: ArrayList<AddressDto>?) : BaseRecycleViewAdapter() {

  private val EDIT_ADDRESS: Int = 2

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_address, parent, false)
    return AddressViewHolder(view)
  }

  override fun getItemCount(): Int {
    if (List != null)
      return List.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (List != null && List.isNotEmpty()) {
      val item = List[position]
      val viewHolder: AddressViewHolder = holder as AddressViewHolder

      viewHolder.userName.text = item.userName
      viewHolder.userPhone.text = item.userPhone
      viewHolder.userAddress.text = item.userAddress
      viewHolder.ward.text = item.ward
      viewHolder.district.text = item.district
      viewHolder.city.text = item.city
      if (item.addressDefault != null && item.addressDefault!!) {
        viewHolder.addressDefault.visibility = View.VISIBLE
      } else viewHolder.addressDefault.visibility = View.INVISIBLE
      viewHolder.thumbnailClick.setOnClickListener {
        onClick(item,position)
      }
    }
  }

  open fun onClick(address: AddressDto,position: Int) {
    val intent = Intent(context, AddEditAddress::class.java)
      .putExtra("NameActivity", R.string.edit_my_address)
      .putExtra("Address",address)
      .putExtra("position",position)
    (context as Activity).startActivityForResult(intent, EDIT_ADDRESS)
  }


}
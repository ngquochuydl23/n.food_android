package com.nfood.nfood.Profile.Address

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nfood.nfood.Adapter.RecycleView.AddressAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Profile.AddressDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_address.header
import kotlinx.android.synthetic.main.activity_address.swipeRefreshLayout

class Address : BaseActivity() {

  private var adapter: AddressAdapter? = null
  private val listAddress = arrayListOf<AddressDto>()
  private val ADD_ADDRESS: Int = 1
  private val EDIT_ADDRESS: Int = 2

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_address)
    getActionBar(header, getString(R.string.my_address))
    recyclerView.layoutManager = LinearLayoutManager(this)


    val address = AddressDto().apply {
      userName = "Ngọc Vân"
      userPhone = "0938288768"
      userAddress = "59 Xô Viết Nghệ Tỉnh, P7, Đà Lạt"
      ward = "Phường 7"
      district = "Thành phố Đà Lạt"
      city = "Lâm Đồng"
      addressDefault = true
    }
    add_address_click.setOnClickListener {
      addNewAddress()
    }
    listAddress.add(address)
    adapter = AddressAdapter(listAddress)
    recyclerView.adapter = adapter

    swipeRefreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
      override fun onRefresh() {
        refreshData()
        swipeRefreshLayout.isRefreshing = false
      }
    })
  }
  private fun refreshData() {

  }
  private fun addNewAddress() {
    val intent = Intent(this, AddEditAddress::class.java)
      .putExtra("NameActivity", R.string.add_new_address)
    startActivityForResult(intent, ADD_ADDRESS)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == ADD_ADDRESS) {
      when (resultCode) {
        Activity.RESULT_OK -> {
          var newAddress = data!!.getSerializableExtra("Address") as AddressDto
          listAddress.add(newAddress)
          adapter!!.notifyDataSetChanged()
        }
      }
    } else if (requestCode == EDIT_ADDRESS){
      when (resultCode) {
        Activity.RESULT_OK -> {
          val position = data!!.getIntExtra("position",0)
          var newAddress = data!!.getSerializableExtra("Address") as AddressDto
          listAddress.set(position,newAddress)
          adapter!!.notifyItemChanged(position)
        }
      }
    }
  }




}

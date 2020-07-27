package com.nfood.nfood.Cart

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.AddressAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Profile.AddressDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_select_address.*

class SelectAddress : BaseActivity() {

  private val listAddress = arrayListOf<AddressDto>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_address)

    getActionBar(header,getString(R.string.select_address))

    recyclerView.layoutManager = LinearLayoutManager(this)

    val address = AddressDto().apply {
      userName = "Vũ Hoàng Uyên Nhi"
      userPhone = "0917833891"
      userAddress = "175 Nguyễn Thị Thập, P.Tân Phong, Q.7, TP.HCM"
      ward = "Phường Tân Phong"
      district = "Quận 7"
      city = "Thành phó Hồ Chí Minh"
      addressDefault = true
    }
    val address1 = AddressDto().apply {
      userName = "Nguyễn Quốc Huy"
      userPhone = "0868684961"
      userAddress = "59 Xô Viết Nghệ Tỉnh, P7, Đà Lạt"
      ward = "Phường 7"
      district = "Thành phố Đà Lạt"
      city = "Lâm Đồng"
      addressDefault = false
    }
    val address2 = AddressDto().apply {
      userName = "Nguyễn Quốc Huy"
      userPhone = "0868684961"
      userAddress = "175 Nguyễn Thị Thập, P.Tân Phong, Q.7, TP.HCM"
      ward = "Phường Tân Phong"
      district = "Quận 7"
      city = "Thành phó Hồ Chí Minh"
      addressDefault = false
    }
    listAddress.add(address)
    listAddress.add(address2)
    listAddress.add(address1)

    recyclerView.adapter = object : AddressAdapter(listAddress) {
      override fun onClick(address: AddressDto, position: Int) {
        val returnIntent = Intent()
        val selectAddress = listAddress[position]
        returnIntent.putExtra("SelectAddress", selectAddress)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
      }
    }
  }
}

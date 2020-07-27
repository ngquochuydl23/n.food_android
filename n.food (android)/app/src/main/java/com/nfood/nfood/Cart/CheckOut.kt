package com.nfood.nfood.Cart

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.CartRestaurantAdapter
import com.nfood.nfood.Adapter.RecycleView.OrderAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Homescreen.OrderProductDto
import com.nfood.nfood.HttpClient
import com.nfood.nfood.Interface_Service.IList
import com.nfood.nfood.Interface_Service.ListTab
import com.nfood.nfood.Interface_Service.Result
import com.nfood.nfood.Profile.AddressDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_check_out.*
import kotlinx.android.synthetic.main.activity_check_out.header
import kotlinx.android.synthetic.main.activity_check_out.recyclerView
import retrofit2.Call
import retrofit2.Response

class CheckOut : BaseActivity() {

  private val SELECT_ADDRESS = 3
  private val SELECT_PAYMENT = 4
  private val SELECT_VOUCHER = 5

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_check_out)
    getActionBar(header,getString(R.string.check_out))
    recyclerView.layoutManager = LinearLayoutManager(this)
    val address = AddressDto().apply {
      userName = "Vũ Hoàng Uyên Nhi"
      userPhone = "0917833891"
      userAddress = "175 Nguyễn Thị Thập, P.Tân Phong, Q.7, TP.HCM"
    }
    getAddress(address)
    select_address.setOnClickListener {
      val intent = Intent(this, SelectAddress::class.java)
      startActivityForResult(intent,SELECT_ADDRESS)
    }
    select_payment.setOnClickListener {
      val intent = Intent(this, SelectPayment::class.java)
      startActivityForResult(intent,SELECT_PAYMENT)
    }
    select_voucher.setOnClickListener {
      val intent = Intent(this, SelectVoucher::class.java)
      startActivityForResult(intent,SELECT_VOUCHER)
    }

    ////////////////////////////////////////////////////
    val orderItem1 = OrderProductDto().apply {
      productName = "Gongcha Matcha"
      productNumber = 2
      productCost = "40.000đ"
      productImage = "https://gongcha.com.vn/wp-content/uploads/2018/10/Hinh-Web-OKINAWA-TR%C3%80-S%E1%BB%AEA.png"

    }
    val orderItem2 = OrderProductDto().apply {
      productName = "Gongcha Okinawa"
      productNumber = 1
      productNote = "Ít đường"
      productCost = "40.000đ"
      productImage = "https://gongcha.com.vn/wp-content/uploads/2018/10/Hinh-Web-OKINAWA-SUA-TUOI.png"

    }
    val orderItem3 = OrderProductDto().apply {
      productName = "Gà rán combo 3"
      productNumber = 1
      productCost = "40.000đ"
      productImage = "https://www.pngitem.com/pimgs/m/47-472421_mac-cheese-kfc-hd-png-download.png"

    }
    val restaurant = arrayListOf<OrderProductDto>()
    restaurant.add(orderItem1)
    restaurant.add(orderItem2)
    var listOrder1 = OrderRestaurantDto().apply {
      restaurantName = "Gongcha Phú Mỹ Hưng"
      listOrder = restaurant
    }
    val list  = arrayListOf<OrderRestaurantDto>()
    list.add(listOrder1)




    val kfc = arrayListOf<OrderProductDto>()
    kfc.add(orderItem3)

    val listOrder2 = OrderRestaurantDto().apply {
      restaurantName = "KFC Phan Bội Châu"
      listOrder = kfc
    }
    list.add(listOrder2)
    ////////////////////////////////////////////////////////////////////
    recyclerView.adapter = OrderAdapter(list)
    orderClick.setOnClickListener {
      val intent = Intent(this, FindDriver::class.java)
      startActivity(intent)
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    when(requestCode){
      SELECT_ADDRESS->{
        if(resultCode == Activity.RESULT_OK){
          val selectedAddress = data!!.getSerializableExtra("SelectAddress") as AddressDto
          getAddress(selectedAddress)
        }
      }
      SELECT_PAYMENT->{
        if(resultCode == Activity.RESULT_OK){
//          val selectedAddress = data!!.getSerializableExtra("SelectAddress") as AddressDto
//          getAddress(selectedAddress)
        }
      }
      SELECT_VOUCHER->{
        if(resultCode == Activity.RESULT_OK){
//          val selectedAddress = data!!.getSerializableExtra("SelectAddress") as AddressDto
//          getAddress(selectedAddress)
        }
      }
    }
  }

  private fun getAddress(selectedAddress : AddressDto){
    nameUser.text = selectedAddress.userName
    phoneUser.text = selectedAddress.userPhone
    addressUser.text = selectedAddress.userAddress
  }

}

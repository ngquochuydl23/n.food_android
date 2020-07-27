package com.nfood.nfood.Profile.MyVoucher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.VoucherAdapter
import com.nfood.nfood.Profile.VoucherDto

import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_valid_voucher.*


class ValidVoucher : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_valid_voucher, container, false)
  }
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recyclerView.layoutManager = LinearLayoutManager(context)
    val list = arrayListOf<VoucherDto>()
    val voucher = VoucherDto().apply {
      voucherImage = "https://cf.shopee.vn/file/dde4cee40fa45e73c5ffe5a7a9911110"
    }
    val voucher1 = VoucherDto().apply {
      voucherImage = "https://images.besttemplates.com/740/Modern-Food-Voucher-Template%281%29.jpg"
    }
    list.add(voucher)
    list.add(voucher1)
    recyclerView.adapter = VoucherAdapter(list)
  }
}

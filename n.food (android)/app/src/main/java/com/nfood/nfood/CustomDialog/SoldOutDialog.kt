package com.nfood.nfood.CustomDialog

import android.content.Context
import android.widget.Button
import android.widget.TextView
import com.nfood.nfood.R

class SoldOutDialog(context: Context) : BaseDialog(context) {
  var foodName: String? = null

  fun getFoodName(foodName: String) {
    this.foodName = foodName
  }

  override fun onBlindDialog() {
    super.onBlindDialog()
    setContentView(R.layout.layout_sold_out)

    val okButton = view!!.findViewById<Button>(R.id.okButton)

    //foodName.text = this.foodName
    okButton.setOnClickListener {
      dismiss()
    }
  }
}
package com.nfood.nfood.CustomDialog

import android.content.Context
import android.widget.Button
import android.widget.TextView
import com.nfood.nfood.R

open class LoadingDialog(context: Context) : BaseDialog(context){

  override fun onBlindDialog() {
    super.onBlindDialog()
    setContentView(R.layout.layout_loading)
    setCanceledOnTouchOutside(false)
  }

}
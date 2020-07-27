package com.nfood.nfood.CustomDialog

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.nfood.nfood.R

open class BaseDialog(val context: Context) {

  private var dialog: MaterialDialog? = null

  var view: View? = null

  fun setContentView(@LayoutRes layout: Int) {
    dialog!!.customView(layout,dialogWrapContent = true,noVerticalPadding = true)
    this.view = dialog!!.getCustomView()
  }

  fun showDialog() {
    if (dialog != null)
      dialog!!.show()
  }

  open fun setCanceledOnTouchOutside(isCancel: Boolean) {
    dialog!!.cancelOnTouchOutside(false)
  }

  @SuppressLint("ResourceType")
  open fun onBlindDialog() {
    dialog = MaterialDialog(context).show {
      cornerRadius(10f)
    }
  }

  open fun dismiss() {
    if (dialog != null)
      dialog!!.dismiss()
  }

}
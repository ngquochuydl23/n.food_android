package com.nfood.nfood.CustomDialog

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.nfood.nfood.R

open class ConfirmDialog(context: Context) : BaseDialog(context){

  private var titleDialog: String? = null
  private var messageDialog: String? = null

  fun setDescription(title: String, message: String) {
    titleDialog = title
    messageDialog = message
  }

  override fun onBlindDialog() {
    super.onBlindDialog()
    setContentView(R.layout.layout_confirm_dialog)

    val title = view!!.findViewById<TextView>(R.id.title)
    val message = view!!.findViewById<TextView>(R.id.message)
    val cancelButton = view!!.findViewById<Button>(R.id.cancel_click)
    val confirmButton = view!!.findViewById<Button>(R.id.confirm_click)

    title.text = titleDialog
    message.text = messageDialog

    cancelButton.setOnClickListener {
      dismiss()
    }
    confirmButton.setOnClickListener {
      onConfirmClick()
      dismiss()
    }

  }
  open fun onConfirmClick() {
    dismiss()
  }

}


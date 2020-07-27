package com.nfood.nfood.Profile.UserInformation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.nfood.nfood.Application
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.CustomDialog.ConfirmDialog
import com.nfood.nfood.Interface_Service.ProfileOutputDto
import com.nfood.nfood.R
import com.nfood.nfood.SaveUserInformation
import kotlinx.android.synthetic.main.activity_user_information.*

class UserInformation : BaseActivity() {



  private var avatar_user : String? = null
  private var nameUser : String? = null
  private var addressUser : String? = null
  private var phoneNumber : String? = null
  private var emailUser : String? = null
  private var isChanged : Boolean = false
  private var saveChange : Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_user_information)
    getActionBar(header,title.toString())
    intialData()
    changeTextListener()
    save_change_click.setOnClickListener {
      saveChange()
    }
  }
  private fun intialData(){
    save_change_click.visibility = View.GONE
    val user = SaveUserInformation(this).getData()
    avatar_user = user!!.avatarUser
    if(avatar_user != null && avatar_user!!.isNotEmpty())
      Application(this).setImage(avatar,user.avatarUser)
    edit_name.setText(user.nameUser)
    edit_phone.setText(user.phoneNumber)
    edit_email.setText(user.email)
    edit_address.setText(user.address)
  }

  private fun saveChange(){
    saveChange = true
    var userInformation = ProfileOutputDto().apply {
      avatarUser = avatar_user
      nameUser = edit_name.text.toString()
      phoneNumber = edit_phone.text.toString()
      email = edit_email.text.toString()
      address = edit_address.text.toString()
    }
    SaveUserInformation(this).setData(userInformation)
    finish()
  }

  private fun messageToSaveChange()  = object : ConfirmDialog(this){
    override fun onConfirmClick() {
      super.onConfirmClick()
      saveChange()
    }
  }
  private fun showMessage(){
    messageToSaveChange().apply {
      setDescription("Save change","Do you want to save changes to your profile before closing ?")
      showDialog()
    }
  }
  private fun onBack(){
    if(isChanged && !saveChange)
      showMessage()
    else finish()
  }

  override fun getNavigationClick() {
    onBack()
  }
  override fun onBackPressed() {
    onBack()
  }

  fun changeTextListener(){
    onChangeText(edit_name)
    onChangeText(edit_phone)
    onChangeText(edit_email)
    onChangeText(edit_address)
  }

  override fun getActionBar(toolbarLayout: View, titleActionBar: String) {
    val toolbar = toolbarLayout.findViewById<Toolbar>(R.id.toolbar)
    val title = toolbarLayout.findViewById<TextView>(R.id.title)
    title.text = titleActionBar
    toolbar.apply {
      setNavigationIcon(R.drawable.icon_back)
      setNavigationOnClickListener {
        onBack()
      }
    }
  }
  fun onChangeText(text: EditText) {
    text.addTextChangedListener(object : TextWatcher {
      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        save_change_click.visibility = View.VISIBLE
        isChanged = true
        saveChange = false
      }
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
      override fun afterTextChanged(s: Editable?) {

      }
    })
  }
}

package com.nfood.nfood.Profile.Address

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Profile.AddressDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_add_edit_address.*

class AddEditAddress : BaseActivity() {

  private var position: Int? = null
  private var createAddress = true

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_edit_address)
    getNameActionBar()
    getAddress()
    save_change_click.setOnClickListener {
      saveChange()
    }
  }

  private fun getNameActionBar() {
    val titleActivity = intent.getIntExtra("NameActivity", R.string.add_new_address)
    if (titleActivity == R.string.add_new_address) {
      save_change_click.text = getString(R.string.create)
    } else save_change_click.text = getString(R.string.save_change)
    getActionBar(header, getString(titleActivity))
  }

  private fun getAddress() {
    val address = intent.getSerializableExtra("Address") as? AddressDto
    if (address != null) {
      createAddress = false
      position = intent.getIntExtra("position", 0)
      edit_name.setText(address.userName)
      edit_phone.setText(address.userPhone)
      edit_address.setText(address.userAddress)
      edit_ward.setText(address.ward)
      edit_district.setText(address.district)
      edit_city.setText(address.city)
      setDefaultAddress.isChecked = address.addressDefault!!
    }
  }

  private fun saveChange() {

    val newAddress = AddressDto().apply {
      userName = edit_name.text.toString()
      userPhone = edit_phone.text.toString()
      userAddress = edit_address.text.toString()
      ward = edit_ward.text.toString()
      district = edit_district.text.toString()
      city = edit_city.text.toString()
      addressDefault = setDefaultAddress.isChecked
    }

    val returnIntent = Intent()
    returnIntent.apply {
      putExtra("position", position)
      putExtra("Address", newAddress)
    }
    setResult(Activity.RESULT_OK, returnIntent)
    finish()
  }
}

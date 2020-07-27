package com.nfood.nfood.Homescreen

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nfood.nfood.Application
import com.nfood.nfood.Base.BaseFragment
import com.nfood.nfood.CustomDialog.ConfirmDialog
import com.nfood.nfood.CustomDialog.LoadingDialog
import com.nfood.nfood.Profile.AboutNFood.AboutNFood
import com.nfood.nfood.Profile.Address.Address
import com.nfood.nfood.Profile.MyPurchases.MyPurchases
import com.nfood.nfood.Profile.MyVoucher.MyVoucher
import com.nfood.nfood.Profile.NFoodCoin.NFoodCoin
import com.nfood.nfood.Profile.Payment.Payment
import com.nfood.nfood.Profile.Setting.Setting
import com.nfood.nfood.Profile.UserInformation.UserInformation
import com.nfood.nfood.R
import com.nfood.nfood.Register.Register
import com.nfood.nfood.SaveToken
import com.nfood.nfood.SaveUserInformation
import kotlinx.android.synthetic.main.fragment_profile.*


class Profile : BaseFragment() {

  private var token: String? = null
  private var isLogin: Boolean = false
  lateinit var loadingDialog : LoadingDialog

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_profile, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    header.text = getString(R.string.profile)
    loadingDialog = LoadingDialog(context!!)
    getProfile()

    edit_profile_click.setOnClickListener {
      editProfile()
    }

    sign_out_click.setOnClickListener {
      signOut()
    }

    sign_in_click.setOnClickListener {
      signIn()
    }

    my_order_click.setOnClickListener {
      myOrder()
    }

    for_seller_click.setOnClickListener {
      forSeller()
    }
    address_click.setOnClickListener {
      address()
    }
    for_driver_click.setOnClickListener {
      forDriver()
    }
//    my_voucher_click.setOnClickListener {
//      myVoucher()
//    }
    aboutNFoodClick.setOnClickListener {
      aboutNFood()
    }
//    nfood_coin_click.setOnClickListener {
//      nFoodCoin()
//    }
    policy_click.setOnClickListener {
      policyClick()
    }
    payment_click.setOnClickListener {
      payment()
    }
    setting_click.setOnClickListener {
      setting()
    }
  }

  private fun setting() {
    val intent = Intent(context, Setting::class.java)
    startActivity(intent)
  }

  private fun payment() {
    startActivityForAccount(Payment::class.java)
  }

  private fun policyClick() {
    val intent = Intent(context, com.nfood.nfood.Profile.Policy.UserPolicy::class.java)
    startActivity(intent)
  }

  private fun nFoodCoin() {
    val intent = Intent(context, NFoodCoin::class.java)
    startActivity(intent)
  }

  private fun myOrder(){
    startActivityForAccount(MyPurchases::class.java)
  }

  private fun signIn(){
    val intent = Intent(context, Register::class.java)
    startActivity(intent)
  }

  private fun signOut(){
    handAlert().apply {
      setDescription("Log out", "Do you want to log out NFood ?")
      onBlindDialog()
      showDialog()
    }
  }

  private fun forDriver(){
    startActivityToAnotherApp("com.nfooddriver")
  }
  private fun editProfile(){
    startActivityForAccount(UserInformation::class.java)
  }


  private fun startActivityToAnotherApp(nameApp : String){
    if(checkInstall(nameApp)){
      val intent = context!!.packageManager.getLaunchIntentForPackage(nameApp)
      startActivity(intent)
    } else {
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.shopee.vn"))
      startActivity(intent)
    }
  }

  private fun checkInstall(nameApp : String) : Boolean{
    val packageManager: PackageManager = context!!.packageManager
    try {
      packageManager.getPackageInfo(nameApp,PackageManager.GET_ACTIVITIES)
      return true
    } catch (e: PackageManager.NameNotFoundException) {
      e.printStackTrace()
    }
    return false
  }


  private fun forSeller(){
    startActivityToAnotherApp("com.nfoodmerchant")
  }

  private fun address(){
    startActivityForAccount(Address::class.java)
  }

  private fun myVoucher(){
    startActivityForAccount(MyVoucher::class.java)
  }

  private fun aboutNFood(){
    val intent = Intent(context, AboutNFood::class.java)
    startActivity(intent)
  }
  private fun handAlert() = object : ConfirmDialog(context!!) {
    override fun onConfirmClick() {
      super.onConfirmClick()
      loadingDialog.apply {
        onBlindDialog()
        showDialog()
      }
      SaveUserInformation(context!!).deleteData()
      SaveToken(context!!).deleteData()
      loadingDialog.dismiss()
      Homescreen().finish()
      val intent = Intent(context, Homescreen::class.java)
      intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
      startActivity(intent)
      activity!!.finish()
    }
  }

  private fun startActivityForAccount(activity : Class<*>){
    if(isLogin){
      startActivity(Intent(context, activity))
    } else startActivity(Intent(context, Register::class.java))
  }

  private fun getProfile() {
    token = SaveToken(context!!).getData()
    if (token != null) {
      isLogin = true
      sign_out_click.visibility = View.VISIBLE
      edit_profile_click.visibility = View.VISIBLE
      sign_in_click.visibility = View.GONE
      val user = SaveUserInformation(context!!).getData()
      name.text = user!!.nameUser
      Application(context!!)!!.apply {
        getErrorImage(R.drawable.profile)
        setImage(avatar, user!!.avatarUser)
      }
    } else {
      sign_in_click.visibility = View.VISIBLE
      sign_out_click.visibility = View.GONE
      edit_profile_click.visibility = View.GONE
    }
  }
}

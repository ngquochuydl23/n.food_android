package com.nfood.nfood.CustomDialog

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nfood.nfood.Application
import com.nfood.nfood.Messenger.Messenger
import com.nfood.nfood.R


class DriverInformationDto{
  @SerializedName("id")
  @Expose
  var id : String? = null
  @SerializedName("driverName")
  @Expose
  var driverName : String? = null
  @SerializedName("driverAvatar")
  @Expose
  var driverAvatar : String? = null
  @SerializedName("phoneNumber")
  @Expose
  var phoneNumber : String? = null
  @SerializedName("driverRated")
  @Expose
  var driverRated : Float? = null
  @SerializedName("driverMotor")
  @Expose
  var driverMotor : String? = null
}


open class FoundDriverDialog(val activity: Activity) : BaseDialog(activity){

  var driverInformation : DriverInformationDto? = null

  private fun getDriverInformation(driverInformation : DriverInformationDto){
    this.driverInformation = driverInformation
  }

  override fun onBlindDialog() {
    super.onBlindDialog()
    setContentView(R.layout.layout_found_driver)

    val driverAvatar = view!!.findViewById<ImageView>(R.id.driverAvatar)
    val driverName = view!!.findViewById<TextView>(R.id.driverName)
    val driverMotor = view!!.findViewById<TextView>(R.id.driverMotor)
    val driverRated = view!!.findViewById<com.willy.ratingbar.ScaleRatingBar>(R.id.driverRated)
    val call = view!!.findViewById<Button>(R.id.call)
    val messenger = view!!.findViewById<Button>(R.id.messenger)

    driverName.text = driverInformation!!.driverName
    driverMotor.text = driverInformation!!.driverMotor
    driverRated.rating = driverInformation!!.driverRated!!
    Application(activity).setImage(driverAvatar,driverInformation!!.driverAvatar)
    call.setOnClickListener {
      callAction(driverInformation!!.phoneNumber!!)
    }
    messenger.setOnClickListener {
      messengerAction()
    }
  }

  private fun callAction(phoneNumber : String){
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:${phoneNumber}")
    activity!!.startActivity(intent)
  }

  private fun messengerAction(){
    val intent = Intent(context,Messenger::class.java)
    activity!!.startActivity(intent)
  }
}
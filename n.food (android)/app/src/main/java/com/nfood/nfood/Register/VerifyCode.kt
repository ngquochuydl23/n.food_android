package com.nfood.nfood.Register

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nfood.nfood.Homescreen.Homescreen
import com.nfood.nfood.Interface_Service.ProfileOutputDto
import com.nfood.nfood.R
import com.nfood.nfood.SaveToken
import com.nfood.nfood.SaveUserInformation
import kotlinx.android.synthetic.main.fragment_verify_code.*

private const val Phone = "Phone"

class VerifyCode : Fragment() {

  private var phoneNumber: String? = null
  private var resendTimeDuration: Int = 31

  private var isCountDown : Boolean = false
  private var timer : CountDownTimer? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val bundle: Bundle? = this.arguments
    if (bundle != null) {
      phoneNumber = bundle.getString(Phone)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_verify_code, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initailData()
    resend_click.setOnClickListener {
      setResendTime()
    }
    submit_button.setOnClickListener {
      submitButton()
    }
  }
  private fun initailData(){
    text.text = phoneNumber
  }

  private fun submitButton() {
    if(timer != null && isCountDown)
      timer!!.cancel()
    val pinViewValue = pinView.value
    verificationOTPCode(pinViewValue)
  }

  private fun verificationOTPCode(otpCode : String){
    val tokenAuthen = "ngquochuydl123"
    onCompleted(otpCode)
  }

  private fun onCompleted(tokenAuthen : String){
    SaveToken(context!!).setData(tokenAuthen)
    val intent = Intent(context, Homescreen::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    saveUserInformation()
    startActivity(intent)
    activity!!.finish()
  }

  private fun setResendTime() {
    resend_click.visibility = View.GONE
    resend_time.visibility = View.VISIBLE
    timer = object : CountDownTimer((resendTimeDuration * 1000).toLong(), 1000) {
      override fun onTick(millisUntilFinished: Long) {
        isCountDown = true
        if (millisUntilFinished > 10000)
          resend_time.text = "0:${millisUntilFinished / 1000}"
        else resend_time.text = "0:0${millisUntilFinished / 1000}"
      }
      override fun onFinish() {
        resend_click.visibility = View.VISIBLE
        resend_time.visibility = View.GONE
        isCountDown = false
      }
    }
    timer!!.start()
  }


  override fun onDestroyView() {
    if(timer != null && isCountDown)
      timer!!.cancel()
    super.onDestroyView()
  }

  private fun saveUserInformation() {
    var user = ProfileOutputDto()
    user.nameUser = "Ngọc Vân"
    user.avatarUser = "https://scontent-hkg4-1.xx.fbcdn.net/v/t1.15752-9/93860343_2346686558961766_2416565144390729728_n.jpg?_nc_cat=109&_nc_sid=b96e70&_nc_ohc=Q21S0l4zBWUAX_jegF6&_nc_ht=scontent-hkg4-1.xx&oh=cac2d2502ab3896d782103701a72bd4b&oe=5EF2466F"
    user.email = "ngocvan@gmail.com"
    user.phoneNumber = "0938288768"
    user.address = "59 Xô Viết Nghệ Tỉnh, P7, Đà Lạt"
    SaveUserInformation(context).setData(user)
  }
}

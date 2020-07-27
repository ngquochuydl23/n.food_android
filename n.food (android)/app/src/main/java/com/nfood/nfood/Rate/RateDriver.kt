package com.nfood.nfood.Rate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nfood.nfood.Application
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.BaseCallBack
import com.nfood.nfood.HttpClient
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_rate_driver.*


class RateDriver : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_rate_driver)
    getActionBar(header,getString(R.string.rate_driver))
    getDriverInformation()
    skipButton.setOnClickListener {
      onSkip()
    }
    nextButton.setOnClickListener {
      onNext()
    }
  }

  private fun getDriverInformation(){
    //DriverInformationDto()
    Application(this).setImage(driverAvatar,"https://scontent.fdad3-1.fna.fbcdn.net/v/t1.0-9/39807922_117240419220780_7597910125738721280_o.jpg?_nc_cat=102&_nc_sid=174925&_nc_oc=AQkFU-QWeO9oujaql9COyqsAQsPpDFyxLskTBEiuzX_llIj36-OjhF1H9PESO4XcjNE&_nc_ht=scontent.fdad3-1.fna&oh=5d849f9e4a33dc2fe09821d799bb77e1&oe=5F013497")
    driverName.text = "Vũ Hoàng Uyên Nhi"
  }


  private fun onNext(){
    rateDriver()
    startRateRestaurant()
  }

  private fun onSkip(){
    startRateRestaurant()
  }

  private fun rateDriver(){
    val rated = rate.rating
    val review = enterReview.text.toString()
    startRateRestaurant()
  }

  private fun startRateRestaurant(){

  }
}

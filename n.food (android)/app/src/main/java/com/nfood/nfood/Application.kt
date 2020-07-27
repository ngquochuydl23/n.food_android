package com.nfood.nfood

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.squareup.picasso.Picasso

open class Application(val context : Context){

  private var errorImage : Int? = R.color.white

  fun getErrorImage(errorImage : Int?){
    this.errorImage = errorImage
  }

  fun setImage(imageView: ImageView, urlString: String?) {
    if (urlString != null && context != null && urlString.isNotEmpty()) {
      try {
        Picasso.with(context)
          .load(urlString)
          .error(errorImage!!)
          .into(imageView)
      } catch (e: Exception) {
        Toast.makeText(context, "Not load image", Toast.LENGTH_SHORT).show()
      }
    }
  }


  
}
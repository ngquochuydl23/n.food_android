package com.nfood.nfood.Profile.MyPurchases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Profile.PuschasesRestaurantDto

import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_complete_purchases.*


class CompletePurchases : Fragment() {

  private val listItem = arrayListOf<PuschasesRestaurantDto>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_complete_purchases, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

  }
}

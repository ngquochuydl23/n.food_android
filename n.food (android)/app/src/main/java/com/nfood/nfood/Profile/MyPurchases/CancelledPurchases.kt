package com.nfood.nfood.Profile.MyPurchases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Profile.PuschasesRestaurantDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_cancelled_purchases.*

class CancelledPurchases : Fragment() {

  private val listItem = arrayListOf<PuschasesRestaurantDto>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_cancelled_purchases, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    recyclerView.layoutManager = LinearLayoutManager(context)
//    recyclerView.adapter = OrderHistoryAdapter(listItem)

  }
}

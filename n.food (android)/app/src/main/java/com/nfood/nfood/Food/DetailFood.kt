package com.nfood.nfood.Food

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.nfood.nfood.Adapter.RecycleView.OptionAdapter
import com.nfood.nfood.Application
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Models.ItemCheckedRadio
import com.nfood.nfood.Models.ItemOption
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_detail_food.*
import kotlinx.android.synthetic.main.activity_detail_food.appBarLayout
import kotlinx.android.synthetic.main.activity_detail_food.collapseTitle
import kotlinx.android.synthetic.main.activity_detail_food.toolbar


class DetailFood : BaseActivity() {

  private var numberItemOrder : Int = 0
  private var noteMerchant : String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail_food)
    listOption.layoutManager = LinearLayoutManager(this)

    val imageFood =
      "https://i.pinimg.com/originals/7d/9d/e8/7d9de8ae3a0444512f963b07ae4f8eff.jpg"
    getImage(imageFood)
    getListOption()
    collapsingToolbarLayout()
    addCartClick.setOnClickListener {
      finish()
      addToCart()
    }
    increaseClick.setOnClickListener {
      increaseFood()
    }
    decreaseClick.setOnClickListener {
      decreaseFood()
    }

  }

  private fun getImage(imageFood : String){
    Application(this).setImage(image,imageFood)
  }

  private fun navigationToolbar(){
    toolbar.setNavigationOnClickListener{
      finish()
    }
  }

  private fun addToCart(){
    noteMerchant = enterNote.text.toString()
    //post
  }

  private fun increaseFood(){
    numberItemOrder++
    numberItem.text = numberItemOrder.toString()
  }

  private fun decreaseFood(){
    if(numberItemOrder > 0){
      numberItemOrder--
      numberItem.text = numberItemOrder.toString()
    }
  }

  private fun collapsingToolbarLayout(){
    setSupportActionBar(toolbar)
    collapseTitle.visibility = View.GONE
    navigationToolbar()
    appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
      var scrollRange = -1
      override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if(scrollRange == -1){
          scrollRange = appBarLayout?.totalScrollRange!!
        }
        if(verticalOffset < 0 && verticalOffset <= -(scrollRange/2)){
          collapseTitle.visibility = View.VISIBLE
        } else if(verticalOffset == 0){
          collapseTitle.visibility = View.GONE
        } else if(verticalOffset > -(scrollRange/2)){
          collapseTitle.visibility = View.GONE
        }
      }
    })
  }


  private fun getListOption() {
    val itemChecked = ItemCheckedRadio().apply {
      checkedTitle = "Kem Sữa"
      checkRadio = false
      checkedBonus="5.000đ"
    }
    val itemChecked1 = ItemCheckedRadio().apply {
      checkedTitle = "Trân Châu Đường Đen"
      checkRadio = false
      checkedBonus="5.000đ"
    }
    val itemChecked2 = ItemCheckedRadio().apply {
      checkedTitle = "Trân Châu Hoàng Gia"
      checkRadio = false
      checkedBonus="5.000đ"
    }
    val sizeItemOption1 =  ItemCheckedRadio().apply {
      checkedTitle = "Size S"
      checkRadio = false
    }
    val sizeItemOption2 =  ItemCheckedRadio().apply {
      checkedTitle = "Size M"
      checkRadio = false
      checkedBonus="10.000đ"
    }
    val sizeItemOption3 =  ItemCheckedRadio().apply {
      checkedTitle = "Size L"
      checkRadio = false
      checkedBonus="15.000đ"
    }
    val sizeOption = ItemOption().apply {
      optionTitle = "Size"
      listChecked = arrayListOf(sizeItemOption1, sizeItemOption2, sizeItemOption3)
    }
    val optionItem1 = ItemOption().apply {
      optionTitle = "Topping"
      optionSubtitle="Optional"
      listChecked = arrayListOf(itemChecked, itemChecked1, itemChecked2)
    }
    val listOptionItem1 = arrayListOf(sizeOption, optionItem1)

    listOption.adapter = OptionAdapter(listOptionItem1)

  }
}

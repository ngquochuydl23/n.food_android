package com.nfood.nfood.Homescreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.CategoryAdapter
import com.nfood.nfood.Base.BaseFragment

import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_category.*



class Category : BaseFragment() {
  private val girdLayoutNumber = 2
  val list: ArrayList<CategoryDto> = arrayListOf()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_category, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    header.text = getString(R.string.category)

    list.add(CategoryDto("Seafood ", "12 Place", ""))
    list.add(CategoryDto("Fast Food ", "22 Place", ""))
    list.add(CategoryDto("Drink", "32 Place", ""))
    list.add(CategoryDto("Fruit", "42 Place", ""))
    list.add(CategoryDto("Flower", "52 Place", ""))
    list.add(CategoryDto("Vegetable", "12 Place", ""))
    list.add(CategoryDto("Cake", "22 Place", ""))

    category_menu.layoutManager = GridLayoutManager(context, girdLayoutNumber)
    category_menu.adapter = CategoryAdapter(list)
  }

}

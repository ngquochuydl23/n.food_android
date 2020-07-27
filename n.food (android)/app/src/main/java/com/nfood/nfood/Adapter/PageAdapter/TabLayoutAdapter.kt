package com.nfood.nfood.Adapter.PageAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabLayoutAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

  var listFragmentPager = arrayListOf<Fragment>()
  var size : Int? = null

  override fun getItem(position: Int): Fragment {
    return listFragmentPager[position]
  }

  override fun getCount(): Int {
    if(size != null)
      return size!!
    return 0
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return super.getPageTitle(position)
  }
}
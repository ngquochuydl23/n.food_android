package com.nfood.nfood.Base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nfood.nfood.R


abstract class BaseActivity : AppCompatActivity() {

  private var exitApplication : Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  open fun hideSoftKeyboard(activity: Activity) {
    val inputMethodManager: InputMethodManager = activity.getSystemService(
      Activity.INPUT_METHOD_SERVICE
    ) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(
      activity.currentFocus!!.windowToken, 0
    )
  }

  open fun addFragment(fragment: Fragment,tag : String) {
    val transaction = supportFragmentManager
    transaction
      .beginTransaction()
      .add(R.id.container, fragment,tag)
      .addToBackStack(tag)
      .commit()
  }

  open fun getViewPaper(viewPager : ViewPager,tabLayout: TabLayout){
    viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab) {
        viewPager.currentItem = tab.position
      }
      override fun onTabUnselected(tab: TabLayout.Tab) {}
      override fun onTabReselected(tab: TabLayout.Tab) {}
    })
  }


  open fun getActionBar(toolbarLayout: View, titleActionBar : String) {
    val toolbar = toolbarLayout.findViewById<Toolbar>(R.id.toolbar)
    val title = toolbarLayout.findViewById<TextView>(R.id.title)
    title.text = titleActionBar
    toolbar.apply {
      setNavigationIcon(R.drawable.icon_back)
      setNavigationOnClickListener {
        getNavigationClick()
      }
    }
  }
  open fun getNavigationClick(){
    finish()
  }
}
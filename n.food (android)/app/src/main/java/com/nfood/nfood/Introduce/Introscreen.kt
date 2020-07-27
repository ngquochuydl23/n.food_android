package com.nfood.nfood.Introduce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.nfood.nfood.Adapter.PageAdapter.IntroduceAdapter
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_introscreen.*

class Introscreen : AppCompatActivity() {



  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_introscreen)
    val Item = ArrayList<IntroItem>()
    Item.add(IntroItem("Nguyễn", "", ""))
    Item.add(IntroItem("Quốc", "", ""))
    Item.add(IntroItem("Huy", "", ""))
    next_intro.setOnClickListener {
      var position = viewPager.currentItem
      if (position == Item.size - 1)
        lastItem()
      if (next_intro.text == "DONE" && position == Item.size - 1)
        //Navigation(this).gotoActivity(MainActivity::class.java, null, null, true)
      else {
        position++
        viewPager.currentItem = position
      }
    }
    skip_click.setOnClickListener {
      //Navigation(this).gotoActivity(MainActivity::class.java, null, null, true)
    }

    viewPager.adapter = IntroduceAdapter(Item)
    tab_layout.setupWithViewPager(viewPager)
    tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab) {
        if (tab.position == Item.size - 1)
          lastItem()
        else default()
      }
      override fun onTabUnselected(tab: TabLayout.Tab) {}
      override fun onTabReselected(tab: TabLayout.Tab) {}
    })
  }

  private fun lastItem() {
    next_intro.text = "DONE"
  }

  private fun default() {
    next_intro.text = "NEXT"
  }
}

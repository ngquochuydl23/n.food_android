package com.nfood.nfood.Adapter.PageAdapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.nfood.nfood.Introduce.IntroItem
import com.nfood.nfood.R


class IntroduceAdapter(val item : ArrayList<IntroItem>) : BasePageAdapter() {

  override fun getCount(): Int {
    return item.size
  }

  override fun isViewFromObject(view: View, obj: Any): Boolean {
    return view == obj
  }
  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    context = container.context
    val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layoutScreen = inflater.inflate(R.layout.introscreen_layout,null)
    val subtitle = layoutScreen.findViewById<TextView>(R.id.subtitle)
    val title = layoutScreen.findViewById<TextView>(R.id.title)

    title.text = item.get(position).title
    subtitle.text = item.get(position).subtitle

    container.addView(layoutScreen)
    return layoutScreen
  }
  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }
}
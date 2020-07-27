package com.nfood.nfood.Adapter.PageAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.nfood.nfood.Application
import com.nfood.nfood.Homescreen.SlideAdverDto
import com.nfood.nfood.R
import com.squareup.picasso.Picasso


class SlideLayoutAdapter(val listSlide : ArrayList<SlideAdverDto>) : BasePageAdapter() {
  override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view == `object`
  }
  override fun getCount(): Int = listSlide.size

  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    context = container.context
    val inflater : LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val itemView : ViewGroup = inflater.inflate(R.layout.item_slide, container ,false) as ViewGroup

    val image = itemView.findViewById<ImageView>(R.id.image)

    image.setOnClickListener {

    }
    Application(context!!).setImage(image,listSlide[position].image)
    container.addView(itemView)

    return itemView
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }
}
package com.nfood.nfood.Restaurant

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.nfood.nfood.Adapter.PageAdapter.ListImageAdapter
import com.nfood.nfood.Adapter.PageAdapter.TabLayoutAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_restaurant.*


class Restaurant : BaseActivity() {

  private val homeTab = HomeTab()
  private val menuTab = MenuTab()
  private val commentTab = CommentTab()
  private val detailTab = DetailTab()

  private var isFavourite = false

  private val listPage = arrayListOf<Fragment>(homeTab, menuTab, commentTab, detailTab)
  val listImage =
    arrayListOf<String>(
      "https://gongcha.com.vn/wp-content/uploads/2019/06/summer.th%E1%BB%AD395x280-01.jpg"
    )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_restaurant)
    getImage(listImage)
    getPage()
    CollapsingToolbarLayout()
  }

  private fun CollapsingToolbarLayout(){
    setSupportActionBar(toolbar)
    collapseTitle.visibility = View.GONE
    navigationToolbar()
    appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
      var scrollRange = -1
      override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if(scrollRange == -1){
          scrollRange = appBarLayout?.totalScrollRange!!
        }
        if(verticalOffset < 0 && verticalOffset <= -(scrollRange/4)){
          collapseTitle.visibility = View.VISIBLE
        } else if(verticalOffset == 0){
          collapseTitle.visibility = View.GONE
        } else if(verticalOffset > -(scrollRange/4)){
          collapseTitle.visibility = View.GONE
        }
      }
    })
  }

  private fun navigationToolbar(){
    toolbar.setNavigationOnClickListener{
      finish()
    }
  }
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    getMenuInflater().inflate(R.menu.menu_toolbar_restaurant, menu)
    return true
  }

  @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val itemSelected = item.itemId
    when(itemSelected){
      R.id.favouriteToolbar -> {
        if(!isFavourite){
          Toast.makeText(this,"Added to favorites",Toast.LENGTH_SHORT).show()
          item.setIcon(R.drawable.icon_favourite_active)
          isFavourite = true
        } else {
          Toast.makeText(this,"Remove from favorites",Toast.LENGTH_SHORT).show()
          item.setIcon(R.drawable.icon_favourite_unactive)
          isFavourite = false
        }
        return true
      }
      R.id.moreToolbar -> {
        Toast.makeText(this,"More Toolbar",Toast.LENGTH_SHORT).show()
      }
    }
    return false
  }

  private fun getPage() {
    viewPager.adapter = TabLayoutAdapter(supportFragmentManager).apply {
      size = tabLayout.tabCount
      listFragmentPager = listPage
    }
    getViewPaper(viewPager, tabLayout)
  }

  fun getImage(listImage: ArrayList<String>?) {
    val adapter = ListImageAdapter(listImage!!)
    viewImage.adapter = adapter
    indicator.setupWithViewPager(viewImage)
  }

}

package com.nfood.nfood.Homescreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nfood.nfood.Adapter.PageAdapter.SlideLayoutAdapter
import com.nfood.nfood.Adapter.RecycleView.ListTabAdapter
import com.nfood.nfood.Adapter.RecycleView.RestaurantAdapter
import com.nfood.nfood.Base.BaseFragment
import com.nfood.nfood.BaseCallBack
import com.nfood.nfood.HttpClient
import com.nfood.nfood.Interface_Service.ListTab
import com.nfood.nfood.Interface_Service.Result
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface IHome {
  @GET("homescreen")
  fun getHomescreen(): Call<Result<ListTab>>
}

class Home() : BaseFragment(), HttpClient, BaseCallBack<ListTab> {

  lateinit var service: IHome
  lateinit var call: Call<Result<ListTab>>
  private var viewPool = RecyclerView.RecycledViewPool()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_home, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    swipeRefreshLayout()
    searchClick.setOnClickListener {
      val intent = Intent(context, Search::class.java)
      startActivity(intent)
    }
    service = retrofit().create(IHome::class.java)
    call = service.getHomescreen()

    listRestaurant.layoutManager = LinearLayoutManager(context)
    moreRestaurant.layoutManager = LinearLayoutManager(context)
    call.enqueue(this)
    listRestaurant.setHasFixedSize(true)
  }

  override fun onResponse(call: Call<Result<ListTab>>, response: Response<Result<ListTab>>) {
    super.onResponse(call, response)
    if (response.isSuccessful) {
      val list = response.body()!!.result!!
      setListSlide(advertisement, tabLayout, list.listSlide)
      listRestaurant.adapter = ListTabAdapter(list.listTab!!)
      moreRestaurant.adapter = RestaurantAdapter(list.moreRestaurant!!)
      listRestaurant.setRecycledViewPool(viewPool)
    }
  }
  private fun setListSlide(view: ViewPager, tabLayout: TabLayout, list: ArrayList<SlideAdverDto>?) {
    view.adapter = SlideLayoutAdapter(list!!)
    var position = 0
    lateinit var runnable: Runnable
    runnable = Runnable {
      if (position == list.size)
        position = 0
      view.currentItem = position
      position++
      Handler().postDelayed(runnable, 3000)
    }
    Handler().postDelayed(runnable, 3000)
    view.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    tabLayout.setupWithViewPager(view)
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabSelected(tab: TabLayout.Tab) {
        view.currentItem = tab.position
        position = tab.position
      }
      override fun onTabUnselected(tab: TabLayout.Tab) {}
      override fun onTabReselected(tab: TabLayout.Tab) {}
    })
  }

  private fun swipeRefreshLayout() {
    swipeRefreshLayout.setOnRefreshListener {
      reloadFragment(this)
    }
  }


}

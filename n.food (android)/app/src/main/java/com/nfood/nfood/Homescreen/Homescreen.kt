package com.nfood.nfood.Homescreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Cart.Cart
import com.nfood.nfood.R
import com.nfood.nfood.Register.Register
import com.nfood.nfood.SaveToken
import com.nfood.nfood.SaveUserInformation
import kotlinx.android.synthetic.main.activity_homescreen.*
import kotlinx.android.synthetic.main.fragment_home.*


class Homescreen : BaseActivity() {

  private var token: String? = null
  private var nameUser: String? = null
  private var isLogin: Boolean = false
  private val HomeFragmentTag = "HomeFragment"
  private val DiscoverFragmentTag = "DiscoverFragment"
  private val CategoryFragmentTag = "CategoryFragment"
  private val NotificationFragmentTag = "NotificationFragment"
  private val ProfileFragmentTag = "ProfileFragment"

  private val HomeFragment = Home()
  private val DiscoverFragment = Discover()
  private val CategoryFragment = Category()
  private val NotificationFragment = Notifications()
  private val ProfileFragment = Profile()

  private var currentFragment : Fragment? = null
  private var currentFragmentTag : String? = null


  private fun startActivities(activity: Class<*>) {
    val intent = Intent(this, activity)
    startActivity(intent)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_homescreen)
    initial()

    PushNotification()

    selectBottomNavigationItem()
    cart()
  }

  private fun PushNotification(){
    FirebaseMessaging.getInstance().subscribeToTopic("event")
      .addOnCompleteListener(object : OnCompleteListener<Void> {
        override fun onComplete(task: Task<Void>) {
          var msg = "Successfull"
          if(!task.isSuccessful){
            msg = "Failed"
          }
          Log.d("task",msg)
        }
      })
  }
  private fun getUserInformation() {
    token = SaveToken(this).getData()
    if (token != null) {
      isLogin = true
      nameUser = SaveUserInformation(this).getData()?.nameUser
    }
  }

  private fun removeNotificationBadge(){
    navigation_view.getBadge(R.id.notification)?.let {
      if(it.isVisible){
        navigation_view.removeBadge(R.id.notification)
      }
    }
  }

  private fun showNotificationBadge(){

  }
  private fun initial() {
    getUserInformation()
    currentFragment = HomeFragment
    currentFragmentTag = HomeFragmentTag
    getCurrentItemBottomNavigation(currentFragmentTag!!)
    val transaction = supportFragmentManager
    transaction.beginTransaction()
      .add(R.id.container, HomeFragment, HomeFragmentTag).commit()
    transaction.beginTransaction()
      .add(R.id.container, CategoryFragment, CategoryFragmentTag)
      .hide(CategoryFragment).commit()
    transaction.beginTransaction()
      .add(R.id.container, NotificationFragment, NotificationFragmentTag)
      .hide(NotificationFragment).commit()
    transaction.beginTransaction()
      .add(R.id.container, ProfileFragment, ProfileFragmentTag)
      .hide(ProfileFragment).commit()
  }

  override fun onBackPressed() {
    if(currentFragmentTag != HomeFragmentTag){
      selectFragment(HomeFragment)
    }
    else super.onBackPressed()
  }
  private fun cart() {
    cart_click.setOnClickListener {
      if (!isLogin)
        startActivities(Register::class.java)
      else startActivities(Cart::class.java)
    }
  }

  private fun selectBottomNavigationItem(){
    navigation_view.setOnNavigationItemSelectedListener {
      when (it.itemId) {
        R.id.home -> {
          selectFragment(HomeFragment)
          return@setOnNavigationItemSelectedListener true
        }
        R.id.category -> {
          selectFragment(CategoryFragment)
          return@setOnNavigationItemSelectedListener true
        }
        R.id.notification -> {
          if (!isLogin)
            startActivities(Register::class.java)
          else {
            selectFragment(NotificationFragment)
            return@setOnNavigationItemSelectedListener true
          }
        }
        R.id.profile -> {
          selectFragment(ProfileFragment)
          return@setOnNavigationItemSelectedListener true
        }
      }
      false
    }
  }


  private fun getCurrentItemBottomNavigation(currentFragmentTag : String) {
    when(currentFragmentTag){
      HomeFragmentTag ->
        navigation_view.selectedItemId = R.id.home
      CategoryFragmentTag ->
        navigation_view.selectedItemId = R.id.category
      NotificationFragmentTag ->
        navigation_view.selectedItemId = R.id.notification
      ProfileFragmentTag ->
        navigation_view.selectedItemId = R.id.profile
    }
  }
  private fun selectFragment(fragment : Fragment){
    val transaction = supportFragmentManager.beginTransaction()
    if(currentFragment != fragment){
      transaction.hide(currentFragment!!).show(fragment).commit()
      currentFragment = fragment
      currentFragmentTag = currentFragment!!.tag
      getCurrentItemBottomNavigation(currentFragmentTag!!)
    }
  }
}

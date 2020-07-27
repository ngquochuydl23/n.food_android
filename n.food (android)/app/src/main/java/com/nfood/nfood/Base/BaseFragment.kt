package com.nfood.nfood.Base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nfood.nfood.R

abstract class BaseFragment : Fragment() {

  fun replaceFragment(fragment: Fragment) {
    val transaction = activity!!.supportFragmentManager
    transaction
      .beginTransaction()
      .replace(R.id.container, fragment)
      .addToBackStack(tag)
      .commit()
  }

  fun ToastMessenger(text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
  }

  fun reloadFragment(fragment: Fragment){
    val transaction = activity!!.supportFragmentManager
    transaction.beginTransaction()
      .detach(fragment)
      .attach(fragment)
      .commit()
  }

  fun onChangeText(text: TextView, textError: TextView) {

  }

  fun runnable(handling: () -> Unit) {
    lateinit var runnable: Runnable
    runnable = Runnable {
      handling()
      Handler().postDelayed(runnable, 1000)
    }
    Handler().postDelayed(runnable, 1000)
  }

  fun checkConnectNetwork(): Boolean {
    val connectivityManager =
      context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting() ?: false
  }
}
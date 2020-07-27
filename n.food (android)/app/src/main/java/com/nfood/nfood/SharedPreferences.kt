package com.nfood.nfood

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.nfood.nfood.Interface_Service.ProfileOutputDto


abstract class SharedPref<T>(val context: Context?) {
  protected val sharedPreferences = context!!.getSharedPreferences(setName(), Context.MODE_PRIVATE)
  protected val editor: SharedPreferences.Editor = sharedPreferences.edit()
  abstract fun setData(data: T)
  abstract fun getData(): T?
  abstract fun deleteData()
  abstract fun setName(): String
}

class SaveToken(context: Context?) : SharedPref<String?>(context) {
  private val token = "tokenAuthen"
  override fun setName(): String = SharePreferencesKey().token
  override fun getData(): String? {
    return sharedPreferences.getString(token, null)
  }

  override fun setData(data: String?) {
    editor.putString(token, data).commit()
  }

  override fun deleteData() {
    editor.clear().apply()
  }

}

class SaveUserInformation(context: Context?) : SharedPref<ProfileOutputDto>(context) {
  private val userInformation = "userInformation"

  override fun setName(): String = SharePreferencesKey().userInformation
  override fun setData(data: ProfileOutputDto) {
    editor.putString(userInformation, Gson().toJson(data)).commit()
  }

  override fun getData(): ProfileOutputDto? {
    val res = sharedPreferences.getString(userInformation, null)
//    Log.d("res",res)
    if (res != null && res.isNotEmpty())
      return Gson().fromJson(res, ProfileOutputDto::class.java)
    return null
  }

  override fun deleteData() {
    editor.clear().apply()
  }
}


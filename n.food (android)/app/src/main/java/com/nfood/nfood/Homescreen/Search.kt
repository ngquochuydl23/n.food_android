package com.nfood.nfood.Homescreen

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.SearchHistoryAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.R
import com.nfood.nfood.SQLiteManager.SearchHistoryDataBase
import kotlinx.android.synthetic.main.activity_search.*
import java.text.Normalizer
import java.util.*
import java.util.regex.Pattern


class Search : BaseActivity() {


  private val FILE_NAME = "search_history.json"
  private var listHistory = arrayListOf<SearchHistoryDto>()
  private var adapter: SearchHistoryAdapter? = null
  lateinit var database: SearchHistoryDataBase

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search)
    toolbar.setNavigationOnClickListener {
      finish()
    }
    listSearchHistory.layoutManager = LinearLayoutManager(this)
    database = SearchHistoryDataBase(this)

    searchBar.requestFocus()
    searchAction()
    getFromListSearchHistory()
    deleteClick.setOnClickListener {
      clearHistoryList()
    }
  }

  private fun searchAction() {
    searchBar.setOnEditorActionListener(object : TextView.OnEditorActionListener {
      override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
          searchResult()
          return true
        }
        return false
      }
    })
  }

  private fun searchResult() {
    val keyword: String = searchBar.text.toString()
    val intent = Intent(this, SearchResult::class.java)
      .putExtra("SearchResult", keyword)
    startActivity(intent)
    finish()
    addToListSearchHistory(keyword)
  }

  private fun clearHistoryList() {
    if (listHistory != null && listHistory.isNotEmpty()) {
      database.clearData()
      getFromListSearchHistory()
    }
  }

  private fun deleteItemHistoryList(id: String) {
    database.deleteDataAt(id)
    getFromListSearchHistory()
  }

  private fun addToListSearchHistory(item: String) {
    if (!database.checkExist(item))
      database.insertData(item)
  }

  private fun getFromListSearchHistory() {
    listHistory = database.getData()
    if (listHistory.isEmpty())
      listControlLayout.visibility = View.GONE
    Collections.reverse(listHistory)
    adapter = object : SearchHistoryAdapter(listHistory) {
      override fun deleteItemHistory(id: String) {
        deleteItemHistoryList(id)
      }
    }
    listSearchHistory.adapter = adapter
  }

  private fun toVietNamese(str: String): String {
    var normalizedString: String = Normalizer.normalize(str, Normalizer.Form.NFD)
    var pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
    return pattern.matcher(normalizedString).replaceAll("").toLowerCase()
  }
}

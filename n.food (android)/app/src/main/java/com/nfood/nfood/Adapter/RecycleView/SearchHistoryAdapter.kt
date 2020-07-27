package com.nfood.nfood.Adapter.RecycleView

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Homescreen.SearchHistoryDto
import com.nfood.nfood.Homescreen.SearchResult
import com.nfood.nfood.R

open class SearchHistoryAdapter(val listSearchHistory : ArrayList<SearchHistoryDto>) : BaseRecycleViewAdapter(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_search_history, parent, false)
    return SearchHistoryViewHolder(view)
  }

  override fun getItemCount(): Int {
    if(listSearchHistory != null && listSearchHistory!!.isNotEmpty()){
      return listSearchHistory.size
    }
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if(listSearchHistory != null && listSearchHistory!!.isNotEmpty()){
      val seachHistory  = listSearchHistory!![position]
      val viewHolder: SearchHistoryViewHolder = holder as SearchHistoryViewHolder
      viewHolder.searchText.apply {
        text = seachHistory.keyword
        setOnClickListener {
          val intent = Intent(context, SearchResult::class.java)
            .putExtra("SearchResult",seachHistory.keyword)
          context.startActivity(intent)
          (context as Activity).finish()
        }
      }
      viewHolder.searchDelete.setOnClickListener {
        deleteItemHistory(seachHistory.id!!)
      }

    }
  }
  open fun deleteItemHistory(id : String){

  }
}
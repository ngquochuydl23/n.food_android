package com.nfood.nfood.SQLiteManager

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import android.util.Log
import com.nfood.nfood.Homescreen.SearchHistoryDto
import com.nfood.nfood.SQLiteManager.FeedReaderContract.FeedEntry.COLUMN_SEARCH_TEXT
import com.nfood.nfood.SQLiteManager.FeedReaderContract.FeedEntry.SEARCH_HISTORY_TABLE

object FeedReaderContract {
  object FeedEntry : BaseColumns {
    const val SEARCH_HISTORY_TABLE = "searchHistoryTable"
    const val COLUMN_SEARCH_TEXT = "searchText"
  }
}

class SearchHistoryDataBase(context: Context) :
  BaseSQLite<String>(context, databaseName, databaseVersion) {

  val contentValues = ContentValues()

  override fun sqlCreateEntries(): String {
    return "CREATE TABLE ${SEARCH_HISTORY_TABLE}(" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${COLUMN_SEARCH_TEXT} TEXT)"
  }

  override fun sqlDeleteEntries(): String {
    return "DROP TABLE IF EXISTS ${SEARCH_HISTORY_TABLE}"
  }

  fun insertData(keyword: String) {
    val dbWrite = databaseHelper.writableDatabase
    contentValues.put(COLUMN_SEARCH_TEXT, keyword)
    dbWrite.insert(SEARCH_HISTORY_TABLE, null, contentValues)
    dbWrite.close()
  }

  fun getData(): ArrayList<SearchHistoryDto> {
    val dbRead = databaseHelper.readableDatabase
    val cursor = dbRead.query(SEARCH_HISTORY_TABLE, null, null, null, null, null, null)
    var searchText: String? = null
    var id: String? = null
    val listSearchHistory = ArrayList<SearchHistoryDto>()
    while (cursor.moveToNext()) {
      searchText = cursor.getString(cursor.getColumnIndex(COLUMN_SEARCH_TEXT))
      id = cursor.getString(cursor.getColumnIndex(BaseColumns._ID))
      Log.d("db","${id} : ${searchText}")
      val keyword = SearchHistoryDto().apply {
        this.keyword = searchText
        this.id = id
      }
      listSearchHistory.add(keyword)
    }
    dbRead.close()
    return listSearchHistory
  }

  fun clearData() {
    val dbWrite = databaseHelper.writableDatabase
    dbWrite.delete(SEARCH_HISTORY_TABLE, null, null)
    dbWrite.close()
  }

  fun deleteDataAt(id: String) {
    val dbWrite = databaseHelper.writableDatabase
    dbWrite.delete(SEARCH_HISTORY_TABLE, BaseColumns._ID + "=${id}", null)
    dbWrite.close()
  }

  fun checkExist(keyword: String) : Boolean {
    val dbRead = databaseHelper.readableDatabase
    val query =
      "SELECT ${COLUMN_SEARCH_TEXT} FROM ${SEARCH_HISTORY_TABLE} WHERE ${COLUMN_SEARCH_TEXT}=?"
    val cursor = dbRead.rawQuery(query, arrayOf(keyword))
    Log.d("checkExist", "${cursor.count}")
    dbRead.close()
    if(cursor.count > 0)
      return true
    return false
  }

  companion object {
    private val databaseName = "SearchHistoryDataBase"
    private val databaseVersion = 1
  }

}
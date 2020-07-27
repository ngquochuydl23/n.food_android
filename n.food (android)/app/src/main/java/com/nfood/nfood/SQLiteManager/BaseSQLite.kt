package com.nfood.nfood.SQLiteManager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

abstract class BaseSQLite<T>(val context: Context, databaseName: String, databaseVersion: Int) :
  SQLiteOpenHelper(context, databaseName, null, databaseVersion) {
  protected val databaseHelper = this
  abstract fun sqlCreateEntries() : String
  abstract fun sqlDeleteEntries() : String

  private val sqlCreateEntries = sqlCreateEntries()
  private val sqlDeleteEntries = sqlDeleteEntries()

  override fun onCreate(db: SQLiteDatabase) {
    db.execSQL(sqlCreateEntries)
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    db.execSQL(sqlCreateEntries)
    onCreate(db)
  }

  override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    super.onDowngrade(db, oldVersion, newVersion)
    onUpgrade(db, oldVersion, newVersion)
  }

}
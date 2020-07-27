package com.nfood.nfood.Messenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Adapter.RecycleView.MessengerAdapter
import com.nfood.nfood.Base.BaseActivity
import com.nfood.nfood.Models.MessengerDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.activity_messenger.*

class Messenger : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_messenger)
    getActionBar(header,getString(R.string.chat))
    listChatItem.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, true)
    getListChatItem()
    sendMessenger.setOnClickListener {
      sendMessenger()
    }
  }

  private fun sendMessenger(){
    val contextMessenger = enterMessenger.text.toString()
  }


  private fun getListChatItem(){
    val item = MessengerDto().apply{
      name = "Nguyễn Quốc Huy"
      isFromDriver = false
      contentMessenger = "ChàoChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào Huy"
    }
    val item2 = MessengerDto().apply{
      name = "Nguyễn Quốc Huy"
      isFromDriver = false
      contentMessenger = "ChàoChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào Huy"
    }
    val item1 = MessengerDto().apply {
      name = "Vũ Hoàng Uyên Nhi"
      avatar = "https://scontent-hkg4-1.xx.fbcdn.net/v/t1.15752-9/102880879_296818968028445_3240427016042060754_n.png?_nc_cat=108&_nc_sid=b96e70&_nc_ohc=QEJzhGE6CXkAX9XPALJ&_nc_ht=scontent-hkg4-1.xx&oh=7b9287ed000b4a5959e457af76c4d518&oe=5F15ABF5"
      isFromDriver = true
      contentMessenger = "Chào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào Huy"
    }
    val item0 = MessengerDto().apply {
      name = "Vũ Hoàng Uyên Nhi"
      avatar = "https://scontent-hkg4-1.xx.fbcdn.net/v/t1.15752-9/102880879_296818968028445_3240427016042060754_n.png?_nc_cat=108&_nc_sid=b96e70&_nc_ohc=QEJzhGE6CXkAX9XPALJ&_nc_ht=scontent-hkg4-1.xx&oh=7b9287ed000b4a5959e457af76c4d518&oe=5F15ABF5"
      isFromDriver = true
      contentMessenger = "Chào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào HuyChào Huy"
    }
    val list = arrayListOf<MessengerDto>(item,item1,item2,item0)
    listChatItem.adapter = MessengerAdapter(list)
  }

}

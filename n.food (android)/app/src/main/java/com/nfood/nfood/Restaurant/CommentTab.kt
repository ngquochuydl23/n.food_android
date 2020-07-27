package com.nfood.nfood.Restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfood.nfood.Adapter.RecycleView.CommentAdapter
import com.nfood.nfood.Models.ItemCommentDto
import com.nfood.nfood.R
import kotlinx.android.synthetic.main.fragment_comment.*


class CommentTab : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_comment, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    listComment.layoutManager = LinearLayoutManager(context)
    getListComment()
  }

  private fun getListComment(){
    val itemComment1 = ItemCommentDto().apply {
      avatarUser = "https://scontent.fdad3-3.fna.fbcdn.net/v/t1.15752-9/102880879_296818968028445_3240427016042060754_n.png?_nc_cat=108&_nc_sid=b96e70&_nc_ohc=mG-AG_I038QAX8huxnG&_nc_ht=scontent.fdad3-3.fna&oh=fed09d3f7fbf6ad0c8982d5f79828161&oe=5F09CE75"
      nameUser = "Vũ Hoàng Uyên Nhi"
      descriptionComment = "Ngon !!"
      ratedUser = 4.5f
      timePost = "12/6/2020"
    }
    val itemComment2 = ItemCommentDto().apply {
      avatarUser = "https://scontent.fdad3-3.fna.fbcdn.net/v/t1.15752-9/104231167_1181228845557849_4648153100484494001_n.png?_nc_cat=109&_nc_sid=b96e70&_nc_ohc=IRz4yApBHZQAX_GhnJT&_nc_ht=scontent.fdad3-3.fna&oh=95a5e7dae490f45b7df642429fae564b&oe=5F096A89"
      nameUser = "Nguyễn Huy"
      descriptionComment = "Good"
      ratedUser = 5f
      timePost = "12/1/2020"
    }
    val _listComment = arrayListOf(itemComment1,itemComment2)
    listComment.adapter = CommentAdapter(_listComment)
  }
}

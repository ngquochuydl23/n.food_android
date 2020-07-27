package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Models.ItemCommentDto
import com.nfood.nfood.R

class CommentAdapter(val listComment : ArrayList<ItemCommentDto>) : BaseRecycleViewAdapter() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false)
    return CommentViewHolder(view)
  }

  override fun getItemCount(): Int {
    if(listComment != null && listComment.isNotEmpty()){
      return listComment.size
    }
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (listComment != null && listComment.isNotEmpty()) {
      val itemComment = listComment[position]
      val viewHolder: CommentViewHolder = holder as CommentViewHolder

      viewHolder.nameUser.text = itemComment.nameUser
      viewHolder.timePost.text = itemComment.timePost
      Application(context!!).setImage(viewHolder.avatarUser,itemComment.avatarUser)
      viewHolder.descriptionComment.text = itemComment.descriptionComment
      viewHolder.ratedUser.rating = itemComment.ratedUser!!
    }
  }

  class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val avatarUser = itemView.findViewById<ImageView>(R.id.avatarUser)
    val nameUser = itemView.findViewById<TextView>(R.id.nameUser)
    val timePost = itemView.findViewById<TextView>(R.id.timePost)
    val ratedUser = itemView.findViewById<com.willy.ratingbar.ScaleRatingBar>(R.id.ratedUser)
    val descriptionComment = itemView.findViewById<TextView>(R.id.descriptionComment)
  }
}
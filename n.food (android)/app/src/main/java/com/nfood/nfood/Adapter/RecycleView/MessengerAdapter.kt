package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Models.MessengerDto
import com.nfood.nfood.R

class MessengerAdapter(val listMessenger: ArrayList<MessengerDto>) : BaseRecycleViewAdapter() {

  private val MESSENGER_TO_DRIVER = 0
  private val MESSENGER_FROM_DRIVER = 1


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    if (viewType == MESSENGER_FROM_DRIVER) {
      val view =
        LayoutInflater.from(context).inflate(R.layout.item_messenger_from_driver, parent, false)
      return MessengerFromDriverViewHolder(view)
    }
    val view =
      LayoutInflater.from(context).inflate(R.layout.item_messenger_to_driver, parent, false)
    return MessengerToDriverViewHolder(view)
  }

  override fun getItemCount(): Int {
    if (listMessenger != null && listMessenger.isNotEmpty()) {
      return listMessenger.size
    }
    return 0
  }

  override fun getItemViewType(position: Int): Int {
    if (listMessenger[position].isFromDriver!!) {
      return MESSENGER_FROM_DRIVER
    }
    return MESSENGER_TO_DRIVER
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (listMessenger != null && listMessenger.isNotEmpty()) {
      val itemMessenger = listMessenger[position]
      when (holder.itemViewType) {
        MESSENGER_FROM_DRIVER -> {
          val viewHolder: MessengerFromDriverViewHolder = holder as MessengerFromDriverViewHolder
          viewHolder.contentMessenger.text = itemMessenger.contentMessenger
          Application(context!!).setImage(viewHolder.avatar, itemMessenger.avatar)
        }
        MESSENGER_TO_DRIVER -> {
          val viewHolder: MessengerToDriverViewHolder = holder as MessengerToDriverViewHolder
          viewHolder.contentMessenger.text = itemMessenger.contentMessenger
        }
      }
    }

  }

  class MessengerFromDriverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.name)
    val avatar = itemView.findViewById<ImageView>(R.id.avatar)
    val contentMessenger = itemView.findViewById<TextView>(R.id.contentMessenger)
  }

  class MessengerToDriverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.name)
    val contentMessenger = itemView.findViewById<TextView>(R.id.contentMessenger)
  }
}
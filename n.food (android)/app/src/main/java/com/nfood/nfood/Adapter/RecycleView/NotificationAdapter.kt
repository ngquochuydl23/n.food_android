package com.nfood.nfood.Adapter.RecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfood.nfood.Application
import com.nfood.nfood.Notification.NotificationDto
import com.nfood.nfood.R

class NotificationAdapter(val List : ArrayList<NotificationDto>?) : BaseRecycleViewAdapter(){

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    context = parent.context
    val view = LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false)
    return NotificationViewHolder(view)
  }

  override fun getItemCount(): Int {
    if (List != null)
      return List.size
    return 0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if(List != null && List.isNotEmpty()){
      val item = List[position]
      val viewHolder: NotificationViewHolder = holder as NotificationViewHolder
      //onBlind
      viewHolder.title.text = item.title
      viewHolder.subtitle.text = item.subTitle
      viewHolder.time.text = item.time
      Application(context!!).setImage(viewHolder.avatar, item.avatar)
      viewHolder.thumbnailClick.setOnClickListener {
//        bundle.putString(Title,item.title)
//        val intent = Intent(context,CategoryDetail::class.java)
//        intent.putExtras(bundle)
//        context!!.startActivity(intent)
      }
    }
  }

}
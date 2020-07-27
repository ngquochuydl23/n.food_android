package com.nfood.nfood.PushNotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.nfood.nfood.R

class PushNotificationService : FirebaseMessagingService() {
  override fun onMessageReceived(remoteMessage: RemoteMessage) {
    super.onMessageReceived(remoteMessage)
    val titleNotification = remoteMessage.notification!!.title
    val messageNotification = remoteMessage.notification!!.body
    showNotification(titleNotification!!,messageNotification!!)
  }

  private fun showNotification(title : String,message : String){
    val nameChannel = getString(R.string.channel_id)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val descriptionText = "Vhun"
      val importance = NotificationManager.IMPORTANCE_DEFAULT
      val mChannel = NotificationChannel(nameChannel, nameChannel, importance)
      mChannel.description = descriptionText
      val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.createNotificationChannel(mChannel)
    }
    val builder = NotificationCompat.Builder(this,nameChannel)
      .setContentTitle(title)
      .setSmallIcon(R.drawable.avatar_nfood)
      .setAutoCancel(true)
      .setContentText(message)
    val manager = NotificationManagerCompat.from(this)
    manager.notify(999,builder.build())
  }
}
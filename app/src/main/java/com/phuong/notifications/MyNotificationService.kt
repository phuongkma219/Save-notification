package com.phuong.notifications

import android.annotation.SuppressLint
import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import com.phuong.notifications.data.NotificationEntity
import com.phuong.notifications.data.NotificationRepository
import com.phuong.notifications.data.convertDrawableToByteArray
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class MyNotificationService : NotificationListenerService() {
    private var listener: NotificationListener? = null

    fun setNotificationListener(listener: NotificationListener) {
        this.listener = listener
    }
    @SuppressLint("NewApi")
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        if (sbn != null){
            val key = sbn.key
            val appPackage = sbn.opPkg
            val notification = sbn.notification
            val icon = notification?.smallIcon?.loadDrawable(this)
            val title = notification?.extras?.getCharSequence(Notification.EXTRA_TITLE).toString() ?: "unknown"
            val notificationText = notification?.extras?.getCharSequence(Notification.EXTRA_TEXT).toString() ?: "unknown"
            val date = sbn.postTime
            listener?.onNotificationPosted(NotificationEntity(appPackage = appPackage,
                iconImage = convertDrawableToByteArray(icon), title = title, content = notificationText, date = date))
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
    }
    interface NotificationListener {
        fun onNotificationPosted(notificationEntity: NotificationEntity)
    }
}
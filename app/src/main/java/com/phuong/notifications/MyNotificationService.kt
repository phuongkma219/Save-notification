package com.phuong.notifications

import android.annotation.SuppressLint
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNotificationService : NotificationListenerService() {
    @SuppressLint("NewApi")
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        if (sbn != null){
            val key = sbn.key
            val appPackage = sbn.opPkg
            val text = sbn.notification.tickerText?.toString() ?: "unknown"
            val date = sbn.postTime
            Log.d("kkk", "onNotificationPosted: $key -- $appPackage -- $text -- $date")
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
    }
}
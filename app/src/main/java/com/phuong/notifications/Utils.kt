package com.phuong.notifications

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun notificationListenerPermissionGrant(context: Context): Boolean {
    return allPermissionGrant(context, getNotificationPermissions())
}

fun getNotificationPermissions(): Array<String>
       = arrayOf(Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE)


private fun allPermissionGrant(context: Context, intArray: Array<String>): Boolean {
    var isGranted = true
    for (permission in intArray) {
        if (ContextCompat.checkSelfPermission(
                context,
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            isGranted = false
            break
        }
    }
    return isGranted
}
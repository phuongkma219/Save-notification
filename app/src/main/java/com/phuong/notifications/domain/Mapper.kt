package com.phuong.notifications.domain

import com.phuong.notifications.data.NotificationEntity
import com.phuong.notifications.ui.ItemNotification

fun List<NotificationEntity>.convertToItemNotification() : MutableList<ItemNotification>{
    val notificationSet = mutableSetOf<String>()
    val notificationMap = HashMap<String, MutableList<NotificationEntity>>()
    val result = mutableListOf<ItemNotification>()
    for (notification in this) {
        val appPackage = notification.appPackage
        if (!notificationMap.containsKey(appPackage)){
            notificationMap[appPackage] = mutableListOf()
        }
        notificationMap[appPackage]?.add(notification)
        notificationSet.add(notification.appPackage)
    }
    val appPackageList = notificationSet.toList()
    appPackageList.forEach {
        val notis = notificationMap[it]
        result.add(ItemNotification(notis.first().id,it,notis.convert))
    }
}
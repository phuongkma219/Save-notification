package com.phuong.notifications.ui

import android.graphics.drawable.Drawable
import java.util.Date


class ItemNotification(
    val id: Long,
    val appPackage: String,
    val iconImage: Drawable,
    val title: String,
    val content: String,
    val date: Date
)
package com.phuong.notifications.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phuong.notifications.data.NotificationEntity
import com.phuong.notifications.data.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val notificationRepository: NotificationRepository) : ViewModel() {

    fun saveNotification(notificationEntity: NotificationEntity){
        viewModelScope.launch {
            notificationRepository.saveNotification(notificationEntity)
        }
    }

    private fun getListNotification(){
        viewModelScope.launch {

        }
    }

    fun deleteNotification(notificationEntity: NotificationEntity){
        viewModelScope.launch { notificationRepository.deleteNotification(notificationEntity) }
    }
}
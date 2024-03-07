package com.phuong.notifications.ui.home

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

     fun getListNotification(){
        viewModelScope.launch {

            notificationRepository.getALlNotification().collect{lists ->

            }
        }
    }

    fun deleteNotification(id : String){
        viewModelScope.launch { notificationRepository.deleteNotification(id) }
    }
}
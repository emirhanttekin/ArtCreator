package com.emirhantekin.aicreatordemo.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emirhantekin.aicreatordemo.MainApplication
import com.emirhantekin.aicreatordemo.data.User
import com.emirhantekin.aicreatordemo.data.UserDatabase
import com.emirhantekin.aicreatordemo.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(val repositry : UserRepository): ViewModel() {

    suspend fun insertData(user: User) = repositry.addUser(user)


    val getAllData = repositry.readAllData()



}
package com.emirhantekin.aicreatordemo.repository

import androidx.lifecycle.LiveData
import com.emirhantekin.aicreatordemo.data.User
import com.emirhantekin.aicreatordemo.data.UserDao

class UserRepository( val userDao: UserDao) {
    fun readAllData() = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }


}





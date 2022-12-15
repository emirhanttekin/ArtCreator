package com.emirhantekin.aicreatordemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1,
)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao : UserDao
    companion object{
        @Volatile
        var INSTANCE : UserDatabase? = null

        @Synchronized
        fun getDatabaseInstance(context: Context): UserDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,UserDatabase::class.java,"Database").fallbackToDestructiveMigration().build()
            }
            return  INSTANCE!!
        }
    }
}
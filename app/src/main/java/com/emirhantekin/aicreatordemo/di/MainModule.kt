package com.emirhantekin.aicreatordemo.di

import android.app.Application
import androidx.room.Room
import com.emirhantekin.aicreatordemo.data.User
import com.emirhantekin.aicreatordemo.data.UserDao
import com.emirhantekin.aicreatordemo.data.UserDatabase
import com.emirhantekin.aicreatordemo.model.UserViewModel
import com.emirhantekin.aicreatordemo.repository.UserRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { UserViewModel(get()) }
}

val databaseModule = module {

    fun provideDatabase(application: Application): UserDatabase {
        return Room.databaseBuilder(application, UserDatabase::class.java, "Database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideDao(database: UserDatabase): UserDao{
        return database.userDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}

val repositoryModule = module {
    fun provideUserRepository(dao: UserDao): UserRepository {
        return UserRepository(dao)
    }

    single { provideUserRepository(get()) }
}

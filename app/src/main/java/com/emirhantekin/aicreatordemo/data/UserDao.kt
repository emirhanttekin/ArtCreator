package com.emirhantekin.aicreatordemo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query


@Dao
interface UserDao {

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun addUser(user :User)
@androidx.room.Query("SELECT * FROM user_table ORDER BY fie_id ASC") // <- Add a query to fetch all users (in user_table) in ascending order by their IDs.
fun readAllData(): Flow<List<User>>
}
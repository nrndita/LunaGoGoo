package com.example.lunatiket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lunatiket.data.local.dao.UserDao
import com.example.lunatiket.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}

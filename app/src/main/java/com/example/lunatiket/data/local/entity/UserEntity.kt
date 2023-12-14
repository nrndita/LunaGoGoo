package com.example.lunatiket.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String,
    val email: String,
    val password: String
)


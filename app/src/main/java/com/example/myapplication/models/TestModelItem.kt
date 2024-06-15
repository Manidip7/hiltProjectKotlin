package com.example.myapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TestModelItem(
    val body: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)
package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.models.TestModelItem


@Database(entities = [TestModelItem::class], version = 1)
abstract class FakerDB :RoomDatabase(){

    abstract fun getFakerDAO():FakeDAO
}
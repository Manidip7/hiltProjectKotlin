package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.models.TestModelItem

@Dao
interface FakeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addproduct(testModelitem:List<TestModelItem>)

    @Query("SELECT * FROM TestModelItem")
    suspend fun getProduct():List<TestModelItem>
}


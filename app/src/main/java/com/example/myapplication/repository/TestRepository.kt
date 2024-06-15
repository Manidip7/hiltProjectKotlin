package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.TestAPI
import com.example.myapplication.db.FakerDB
import com.example.myapplication.models.TestModelItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TestRepository @Inject constructor(private val testAPI: TestAPI, private val fakerDB: FakerDB) {

    private val _testData = MutableLiveData<List<TestModelItem>>(emptyList())
    val testData : LiveData<List<TestModelItem>>
        get() = _testData

//    suspend fun getData(id: Int){
//        val response = testAPI.getTestData(id)
//        if (response.isSuccessful && response.body() != null){
//            fakerDB.getFakerDAO().addproduct(response.body()!!)
//            _testData.postValue(response.body()!!)
//        }
//    }

    suspend fun getData(){
        val response = testAPI.getTestData()
        Log.d( "getData: ",response.body().toString())
        if (response.isSuccessful && response.body() != null){
            fakerDB.getFakerDAO().addproduct(response.body()!!)
            _testData.postValue(response.body()!!)
        }

//        val memes = fakerDB.getFakerDAO().getProduct()
//        _testData.postValue(memes)
    }

}
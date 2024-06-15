package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.TestModelItem
import com.example.myapplication.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class testViewModel @Inject constructor(private val repository: TestRepository) : ViewModel() {

    val categories: LiveData<List<TestModelItem>>
        get() = repository.testData

//    init {
//        viewModelScope.launch {
//            repository.getData(1)
//        }
//    }


//    fun data(id:Int){
//        viewModelScope.launch {
//            repository.getData(id)
//        }
//
//    }

    fun data(){
        viewModelScope.launch {
            repository.getData()
        }

    }




}
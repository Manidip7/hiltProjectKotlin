package com.example.myapplication.api

import com.example.myapplication.models.TestModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TestAPI {

//    @GET("/posts")
//    suspend fun getTestData(
//        @Query("id") id: Int
//    ): Response<List<TestModelItem>>


    @GET("/posts")
    suspend fun getTestData(): Response<List<TestModelItem>>

}
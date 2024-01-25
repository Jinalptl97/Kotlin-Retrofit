package com.example.myapplication.demoretrofit

import retrofit2.Response
import retrofit2.http.GET

interface AlbumServices {
    @GET("/albums")
    suspend fun getalbums():Response<Albums>
}
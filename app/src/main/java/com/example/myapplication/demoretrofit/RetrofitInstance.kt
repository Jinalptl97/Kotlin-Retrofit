package com.example.myapplication.demoretrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        val mainUrl="https://jsonplaceholder.typicode.com/"


        fun getREtrofitInstance(): Retrofit {
return  Retrofit.Builder()
    .baseUrl(mainUrl)
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
        }
    }
}
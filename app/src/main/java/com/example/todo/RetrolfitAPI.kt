package com.example.todo

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrolfitAPI {

    companion object{
        val MAIN_URL = "https://jsonplaceholder.typicode.com/"

        fun getRetrolfit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}
package com.example.todo

import retrofit2.Response
import retrofit2.http.GET

interface TodosIntance {

    @GET("/todos")
    suspend fun getTodosIntance(): Response<Todos>

}
package com.aravindh.apiservice

import com.aravindh.apiservice.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    suspend fun getUsers(): Response<UserResponse?>

}
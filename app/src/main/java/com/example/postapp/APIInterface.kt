package com.example.postapp


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
    @GET("/test")
    fun getUsers() : Call<List<UserDetailsItem>>

    @POST("/test/")
    fun addUsers(@Body userData:UserDetailsItem): Call<UserDetailsItem>
}
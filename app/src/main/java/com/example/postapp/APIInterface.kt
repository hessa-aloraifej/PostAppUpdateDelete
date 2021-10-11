package com.example.postapp


import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @GET("/test")
    fun getUsers() : Call<List<UserDetailsItem>>

    @POST("/test/")
    fun addUsers(@Body userData:UserDetailsItem): Call<UserDetailsItem>

    @PUT("/test/{pk}")
    fun updateUser(@Path("pk")pk:Int, @Body userData:UserDetailsItem): Call<UserDetailsItem>

    @DELETE("/test/{pk}")
    fun deleteUser(@Path("pk")pk:Int):Call<Void>
}
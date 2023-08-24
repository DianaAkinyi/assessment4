package com.example.assessment4.api

import com.example.assessment4.model.Post
import okhttp3.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
   suspend fun getPosts(): retrofit2.Response<List<Post>>


}

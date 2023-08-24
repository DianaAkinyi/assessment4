package com.example.assessment4.api

import com.example.assessment4.model.Post
import com.example.assessment4.model.PostResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/post")
    fun getposts():Response<PostResponse>
    @GET("/post/{id}")
     fun  getPostById(@Path("id") postId:Int): Response<Post>
}

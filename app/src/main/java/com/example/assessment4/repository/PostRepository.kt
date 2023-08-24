package com.example.assessment4.repository

import com.example.assessment4.api.ApiClient
import com.example.assessment4.api.ApiInterface
import com.example.assessment4.model.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response

class PostRepository {
    val apiClient =ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getPosts(): Response<PostResponse> {
        return  withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}
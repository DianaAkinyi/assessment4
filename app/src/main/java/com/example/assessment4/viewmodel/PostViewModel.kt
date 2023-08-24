package com.example.assessment4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.assessment4.model.Post
import com.example.assessment4.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel {
    val postsRepo= PostRepository()
    val postsLiveData = MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()

    suspend fun fetchPost(){
        viewModelFactory {
            val response =postsRepo.getPosts()
            if(response.isSuccessful){
                postsLiveData.postValue(response.body()?.posts)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
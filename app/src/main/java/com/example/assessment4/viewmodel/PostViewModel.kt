package com.example.assessment4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.assessment4.model.Post
import com.example.assessment4.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel:ViewModel() {
    val postsRepo= PostRepository()
    val postsLiveData = MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchPost(){
        viewModelScope.launch {
            val response=postsRepo.getPosts()
            if(response.isSuccessful){
                val postslist=response.body()?: emptyList()
                postsLiveData.postValue(postslist as List<Post>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
//        viewModelFactory {
//            val response =postsRepo.getPosts()
//            if(response.isSuccessful){
//                postsLiveData.postValue(response.body()?.posts)
//            }
//            else{
//                errorLiveData.postValue(response.errorBody()?.string())
//            }
//        }
    }
}
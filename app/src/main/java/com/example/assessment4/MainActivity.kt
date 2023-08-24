package com.example.assessment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessment4.databinding.ActivityMainBinding
import com.example.assessment4.model.Post
import com.example.assessment4.model.PostAdapter
import com.example.assessment4.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    val postViewModel : PostViewModel by ViewModel()
    lateinit var binding:ActivityMainBinding
    lateinit var  postAdapter: PostAdapter
    var postList:List<Post> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postAdapter= PostAdapter(emptyList())

    }

     override fun onResume() {
        super.onResume()
        postViewModel. fetchPost()
        postViewModel.postsLiveData.observe(this, Observer { postList->
            var postAdapter= PostAdapter(postList?: emptyList())
            binding.rvPosts.layoutManager= LinearLayoutManager(this@MainActivity)
            binding.rvPosts.adapter=postAdapter
            Toast.makeText(
                baseContext,
                "fetched ${postList?.size} posts",
                Toast.LENGTH_LONG
            ).show()
        })
        postViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG)
                .show()
        })
    }}
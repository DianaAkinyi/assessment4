package com.example.assessment4.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment4.databinding.PostListBinding

class PostAdapter (var postList:List<Post>): RecyclerView.Adapter<PostViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            var binding= PostListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return  PostViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            var currentPost = postList[position]
            var binding = holder.binding
            binding.tvUserId.text = currentPost.userId.toString()
            binding.tvId.text = currentPost.id.toString()
            binding.tvTitle.text = currentPost.title.toString()
            binding.tvBody.text = currentPost.body.toString()



        }
        override fun getItemCount(): Int {
            return postList.size
        }
    }

    class PostViewHolder(var binding: PostListBinding): RecyclerView.ViewHolder(binding.root)




package com.androidpaginationexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidpaginationexample.adapter.PostsAdapter
import com.androidpaginationexample.databinding.ActivityMainBinding
import com.androidpaginationexample.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel  by viewModels()
    lateinit var postsAdapter: PostsAdapter
    @ExperimentalPagingApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intiRecyclerView()

        lifecycleScope.launch {
            mainViewModel.getAllPosts().collectLatest { response->
                binding.apply {
                    recyclerview.isVisible = true
                    progressBar.isVisible = false
                }
                postsAdapter.submitData(response)
            }
        }

    }
    private fun intiRecyclerView() {
        binding.apply {

            postsAdapter = PostsAdapter(
                this@MainActivity,
                onPostClick = { position, post ->

                    val intent = Intent(this@MainActivity,DetailActivity::class.java)
                    intent.putExtra("id",post.id.toString())
                    intent.putExtra("title",post.title)
                    intent.putExtra("body",post.body)
                    startActivity(intent)

                }
            )


            recyclerview.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = postsAdapter
            }
        }
    }
}
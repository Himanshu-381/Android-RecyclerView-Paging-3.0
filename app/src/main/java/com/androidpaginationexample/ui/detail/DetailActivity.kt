package com.androidpaginationexample.ui.detail

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
import com.androidpaginationexample.databinding.ActivityDetailBinding
import com.androidpaginationexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    @ExperimentalPagingApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()

    }

    private fun initData() {
        try {
            val intent = intent

            if (intent != null) {
                binding.apply {

                    btnBack.setOnClickListener{
                        onBackPressedDispatcher.onBackPressed()
                    }

                    // Extract values from intent
                    val id = intent.getStringExtra("id")
                    val title = intent.getStringExtra("title")
                    val body = intent.getStringExtra("body")

                    // Set text based on presence of data
                    txtId.text = id?.takeIf { it.isNotEmpty() }?.let { "Id = $it" } ?: ""
                    txtTitle.text = title?.takeIf { it.isNotEmpty() }?.let { "Title = $it" } ?: ""
                    txtBody.text = body?.takeIf { it.isNotEmpty() }?.let { "Body = $it" } ?: ""
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
package com.forbes.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.forbes.app.adapter.BreakingNewsAdapter
import com.forbes.app.databinding.ActivityMainBinding
import com.forbes.app.viewmodel.NewsViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var breakingNewsAdapter: BreakingNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupTabLayout()
        setupRecyclerViews()
        observeViewModel()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.searchButton.setOnClickListener {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
        }

        binding.settingsButton.setOnClickListener {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> showLatestContent()
                    1 -> showMagazineContent()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupRecyclerViews() {
        breakingNewsAdapter = BreakingNewsAdapter { newsItem ->
            // Handle news item click
            Toast.makeText(this, "Clicked: ${newsItem.title}", Toast.LENGTH_SHORT).show()
        }

        binding.breakingNewsRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = breakingNewsAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.breakingNews.observe(this) { news ->
            breakingNewsAdapter.submitList(news)
        }
    }

    private fun showLatestContent() {
        // Implement showing latest content
    }

    private fun showMagazineContent() {
        // Implement showing magazine content
    }
} 
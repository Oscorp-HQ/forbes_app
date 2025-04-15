package com.forbes.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.forbes.app.adapter.BreakingNewsAdapter
import com.forbes.app.adapter.LatestStoriesAdapter
import com.forbes.app.databinding.ActivityMainBinding
import com.forbes.app.viewmodel.NewsViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var breakingNewsAdapter: BreakingNewsAdapter
    private lateinit var latestStoriesAdapter: LatestStoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTabLayout()
        setupRecyclerViews()
        observeViewModel()
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
        // Breaking News Adapter
        breakingNewsAdapter = BreakingNewsAdapter { newsItem ->
            val intent = Intent(this, NewsDetailActivity::class.java).apply {
                putExtra(NewsDetailActivity.EXTRA_NEWS_ITEM, newsItem)
            }
            startActivity(intent)
        }

        binding.breakingNewsRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = breakingNewsAdapter
        }

        // Latest Stories Adapter
        latestStoriesAdapter = LatestStoriesAdapter { newsItem ->
            val intent = Intent(this, NewsDetailActivity::class.java).apply {
                putExtra(NewsDetailActivity.EXTRA_NEWS_ITEM, newsItem)
            }
            startActivity(intent)
        }

        binding.latestStoriesRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = latestStoriesAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.breakingNews.observe(this) { news ->
            breakingNewsAdapter.submitList(news)
            binding.breakingNewsTitle.visibility = if (news.isNotEmpty()) View.VISIBLE else View.GONE
            binding.breakingNewsRecycler.visibility = if (news.isNotEmpty()) View.VISIBLE else View.GONE
        }

        viewModel.latestStories.observe(this) { stories ->
            latestStoriesAdapter.submitList(stories)
            binding.latestStoriesTitle.visibility = if (stories.isNotEmpty()) View.VISIBLE else View.GONE
            binding.latestStoriesRecycler.visibility = if (stories.isNotEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun showLatestContent() {
        binding.latestStoriesContainer.visibility = View.VISIBLE
        binding.magazineContainer.visibility = View.GONE
    }

    private fun showMagazineContent() {
        binding.latestStoriesContainer.visibility = View.GONE
        binding.magazineContainer.visibility = View.VISIBLE
    }
} 
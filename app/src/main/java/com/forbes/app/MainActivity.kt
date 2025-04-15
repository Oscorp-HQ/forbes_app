package com.forbes.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.forbes.app.adapter.BookmarkedStoriesAdapter
import com.forbes.app.adapter.BreakingNewsAdapter
import com.forbes.app.adapter.LatestStoriesAdapter
import com.forbes.app.databinding.ActivityMainBinding
import com.forbes.app.repository.BookmarkRepository
import com.forbes.app.viewmodel.NewsViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var breakingNewsAdapter: BreakingNewsAdapter
    private lateinit var latestStoriesAdapter: LatestStoriesAdapter
    private lateinit var bookmarksAdapter: BookmarkedStoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerViews()
        setupTabLayout()
        observeViewModel()
    }

    private fun setupTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> showLatestContent()
                    1 -> showMagazineContent()
                    2 -> showBookmarksContent()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupRecyclerViews() {
        // Breaking News Adapter
        breakingNewsAdapter = BreakingNewsAdapter(
            onItemClick = { newsItem ->
                val intent = Intent(this, NewsDetailActivity::class.java).apply {
                    putExtra(NewsDetailActivity.EXTRA_NEWS_ITEM, newsItem)
                }
                startActivity(intent)
            },
            onBookmarkClick = { newsItem ->
                viewModel.toggleBookmark(newsItem)
            }
        )

        binding.breakingNewsRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = breakingNewsAdapter
        }

        // Latest Stories Adapter
        latestStoriesAdapter = LatestStoriesAdapter(
            onItemClick = { newsItem ->
                val intent = Intent(this, NewsDetailActivity::class.java).apply {
                    putExtra(NewsDetailActivity.EXTRA_NEWS_ITEM, newsItem)
                }
                startActivity(intent)
            },
            onBookmarkClick = { newsItem ->
                viewModel.toggleBookmark(newsItem)
            }
        )

        binding.latestStoriesRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = latestStoriesAdapter
        }

        // Bookmarked Stories Adapter (specialized adapter for bookmarks)
        bookmarksAdapter = BookmarkedStoriesAdapter(
            onItemClick = { newsItem ->
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java).apply {
                    putExtra(NewsDetailActivity.EXTRA_NEWS_ITEM, newsItem)
                }
                startActivity(intent)
            },
            onBookmarkClick = { newsItem ->
                viewModel.toggleBookmark(newsItem)
            }
        )
        
        binding.bookmarkedStoriesRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = bookmarksAdapter
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

        viewModel.bookmarkedNews.observe(this) { bookmarked ->
            // Debug log
            System.out.println("Bookmarked news in MainActivity: ${bookmarked.size}")
            
            bookmarksAdapter.submitList(bookmarked)
            
            // Update UI visibility based on bookmarked items
            val hasBookmarks = bookmarked.isNotEmpty()
            binding.bookmarkedStoriesTitle.visibility = if (hasBookmarks) View.VISIBLE else View.GONE
            binding.noBookmarksText.visibility = if (!hasBookmarks) View.VISIBLE else View.GONE
            binding.bookmarkedStoriesRecycler.visibility = if (hasBookmarks) View.VISIBLE else View.GONE
        }
        
        // Observe bookmarked IDs to update adapters when bookmark status changes
        BookmarkRepository.bookmarkedIds.observe(this) { _ ->
            // Refresh all adapters to update bookmark icons
            breakingNewsAdapter.notifyDataSetChanged()
            latestStoriesAdapter.notifyDataSetChanged()
        }
    }

    private fun showLatestContent() {
        binding.latestStoriesContainer.visibility = View.VISIBLE
        binding.magazineContainer.visibility = View.GONE
        binding.bookmarksContainer.visibility = View.GONE
    }

    private fun showMagazineContent() {
        binding.latestStoriesContainer.visibility = View.GONE
        binding.magazineContainer.visibility = View.VISIBLE
        binding.bookmarksContainer.visibility = View.GONE
    }

    private fun showBookmarksContent() {
        binding.latestStoriesContainer.visibility = View.GONE
        binding.magazineContainer.visibility = View.GONE
        binding.bookmarksContainer.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        // Refresh data when coming back to this screen
        viewModel.refreshData()
    }
} 
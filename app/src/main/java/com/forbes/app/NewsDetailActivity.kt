package com.forbes.app

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.forbes.app.databinding.ActivityNewsDetailBinding
import com.forbes.app.model.NewsItem
import com.forbes.app.repository.BookmarkRepository
import com.forbes.app.viewmodel.NewsViewModel

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding
    private val viewModel: NewsViewModel by viewModels()
    private var currentNewsItem: NewsItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        currentNewsItem = intent.getSerializableExtra(EXTRA_NEWS_ITEM) as? NewsItem
        currentNewsItem?.let { newsItem ->
            displayNews(newsItem)
            setupBookmarkButton(newsItem)
        }
    }

    private fun displayNews(newsItem: NewsItem) {
        binding.newsTitle.text = newsItem.title
        binding.newsAuthor.text = "By ${newsItem.author}"
        binding.newsDate.text = newsItem.date
        binding.newsContent.text = newsItem.content

        Glide.with(this)
            .load(newsItem.imageUrl)
            .into(binding.newsImage)
    }

    private fun setupBookmarkButton(newsItem: NewsItem) {
        updateBookmarkIcon(newsItem.id)

        binding.detailBookmarkButton.setOnClickListener {
            viewModel.toggleBookmark(newsItem)
            updateBookmarkIcon(newsItem.id)
        }
    }

    private fun updateBookmarkIcon(newsId: String) {
        val isBookmarked = BookmarkRepository.isBookmarked(newsId)
        binding.detailBookmarkButton.setImageResource(
            if (isBookmarked) R.drawable.ic_bookmark_filled
            else R.drawable.ic_bookmark_border
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_NEWS_ITEM = "extra_news_item"
    }
} 
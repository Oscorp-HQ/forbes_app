package com.forbes.app

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.forbes.app.databinding.ActivityNewsDetailBinding
import com.forbes.app.model.NewsItem

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val newsItem = intent.getSerializableExtra(EXTRA_NEWS_ITEM) as? NewsItem
        newsItem?.let { displayNews(it) }
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
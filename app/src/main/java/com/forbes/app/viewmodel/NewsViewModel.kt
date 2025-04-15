package com.forbes.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.forbes.app.model.NewsItem
import com.forbes.app.model.NewsCategory
import com.forbes.app.repository.NewsRepository
import com.forbes.app.repository.BookmarkRepository

class NewsViewModel : ViewModel() {
    private val repository = NewsRepository()

    private val _breakingNews = MutableLiveData<List<NewsItem>>()
    val breakingNews: LiveData<List<NewsItem>> = _breakingNews

    private val _latestStories = MutableLiveData<List<NewsItem>>()
    val latestStories: LiveData<List<NewsItem>> = _latestStories

    private val _magazineStories = MutableLiveData<List<NewsItem>>()
    val magazineStories: LiveData<List<NewsItem>> = _magazineStories
    
    // Generate bookmarked news LiveData by combining all news items with bookmarked IDs
    val bookmarkedNews: LiveData<List<NewsItem>> = BookmarkRepository.bookmarkedIds.map { bookmarkedIds ->
        // Combine all news items
        val allNews = mutableListOf<NewsItem>()
        _breakingNews.value?.let { allNews.addAll(it) }
        _latestStories.value?.let { allNews.addAll(it) }
        _magazineStories.value?.let { allNews.addAll(it) }
        
        // Filter for only the bookmarked items
        allNews.filter { bookmarkedIds.contains(it.id) }
    }

    init {
        loadAllData()
    }
    
    private fun loadAllData() {
        loadBreakingNews()
        loadLatestStories()
        loadMagazineStories()
    }

    private fun loadBreakingNews() {
        val news = repository.getBreakingNews()
        _breakingNews.value = news
    }

    private fun loadLatestStories() {
        val stories = repository.getLatestStories()
        _latestStories.value = stories
    }

    private fun loadMagazineStories() {
        val stories = repository.getMagazineStories()
        _magazineStories.value = stories
    }

    // Get a news item with updated bookmark status
    fun getNewsItemWithBookmarkStatus(newsItem: NewsItem): NewsItem {
        return newsItem.copy(isBookmarked = BookmarkRepository.isBookmarked(newsItem.id))
    }

    fun toggleBookmark(newsItem: NewsItem) {
        // Simply toggle the bookmark in the repository
        BookmarkRepository.toggleBookmark(newsItem.id)
        
        // Force refresh lists to show updated bookmark status
        refreshData()
    }

    fun refreshData() {
        loadAllData()
    }
    
    fun isBookmarked(itemId: String): Boolean {
        return BookmarkRepository.isBookmarked(itemId)
    }
} 
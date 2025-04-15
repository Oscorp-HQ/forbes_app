package com.forbes.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.forbes.app.model.NewsItem
import com.forbes.app.repository.NewsRepository

class NewsViewModel : ViewModel() {
    private val repository = NewsRepository()

    private val _breakingNews = MutableLiveData<List<NewsItem>>()
    val breakingNews: LiveData<List<NewsItem>> = _breakingNews

    private val _latestStories = MutableLiveData<List<NewsItem>>()
    val latestStories: LiveData<List<NewsItem>> = _latestStories

    private val _magazineStories = MutableLiveData<List<NewsItem>>()
    val magazineStories: LiveData<List<NewsItem>> = _magazineStories

    init {
        loadBreakingNews()
        loadLatestStories()
        loadMagazineStories()
    }

    private fun loadBreakingNews() {
        _breakingNews.value = repository.getBreakingNews()
    }

    private fun loadLatestStories() {
        _latestStories.value = repository.getLatestStories()
    }

    private fun loadMagazineStories() {
        _magazineStories.value = repository.getMagazineStories()
    }

    fun refreshData() {
        loadBreakingNews()
        loadLatestStories()
        loadMagazineStories()
    }
} 
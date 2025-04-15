package com.forbes.app.model

data class NewsItem(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val author: String,
    val date: String,
    val content: String,
    val category: NewsCategory
)

enum class NewsCategory {
    BREAKING_NEWS,
    LATEST_STORIES,
    MAGAZINE
} 
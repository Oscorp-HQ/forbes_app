package com.forbes.app.repository

import com.forbes.app.model.NewsItem
import com.forbes.app.model.NewsCategory

class NewsRepository {
    fun getBreakingNews(): List<NewsItem> = listOf(
        NewsItem(
            id = "1",
            title = "Federal Judge Blocks Trump Administration Policy",
            description = "A federal judge has issued a temporary restraining order...",
            imageUrl = "https://example.com/news1.jpg",
            author = "Sarah Johnson",
            date = "2025-04-14",
            content = "Lorem ipsum dolor sit amet...",
            category = NewsCategory.BREAKING_NEWS
        ),
        NewsItem(
            id = "2",
            title = "New AI Model Predicts 44 Earth-like Planets",
            description = "Scientists have discovered potential new habitable worlds...",
            imageUrl = "https://example.com/news2.jpg",
            author = "Michael Chen",
            date = "2025-04-14",
            content = "Using advanced machine learning algorithms...",
            category = NewsCategory.BREAKING_NEWS
        ),
        // Add more breaking news items...
    )

    fun getLatestStories(): List<NewsItem> = listOf(
        NewsItem(
            id = "3",
            title = "Global Markets React to New Trade Policies",
            description = "International markets show mixed reactions...",
            imageUrl = "https://example.com/news3.jpg",
            author = "Emma Wilson",
            date = "2025-04-14",
            content = "Stock markets across Asia and Europe...",
            category = NewsCategory.LATEST_STORIES
        ),
        NewsItem(
            id = "4",
            title = "Tech Giants Announce Breakthrough in Quantum Computing",
            description = "Major advancement in quantum processing...",
            imageUrl = "https://example.com/news4.jpg",
            author = "David Lee",
            date = "2025-04-14",
            content = "In a groundbreaking announcement...",
            category = NewsCategory.LATEST_STORIES
        ),
        // Add more latest stories...
    )

    fun getMagazineStories(): List<NewsItem> = listOf(
        NewsItem(
            id = "5",
            title = "The Future of Work: AI and Human Collaboration",
            description = "How artificial intelligence is reshaping workplaces...",
            imageUrl = "https://example.com/magazine1.jpg",
            author = "Jennifer Brown",
            date = "2025-04-14",
            content = "As we enter a new era of technological advancement...",
            category = NewsCategory.MAGAZINE
        ),
        // Add more magazine stories...
    )
} 
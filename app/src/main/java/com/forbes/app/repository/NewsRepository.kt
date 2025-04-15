package com.forbes.app.repository

import com.forbes.app.model.NewsItem
import com.forbes.app.model.NewsCategory

class NewsRepository {
    fun getBreakingNews(): List<NewsItem> = listOf(
        NewsItem(
            id = "1",
            title = "Federal Judge Blocks Trump Administration Policy",
            description = "A federal judge has issued a temporary restraining order...",
            imageUrl = "https://picsum.photos/400/300?random=1",
            author = "Sarah Johnson",
            date = "2025-04-14",
            content = "Lorem ipsum dolor sit amet...",
            category = NewsCategory.BREAKING_NEWS
        ),
        NewsItem(
            id = "2",
            title = "New AI Model Predicts 44 Earth-like Planets",
            description = "Scientists have discovered potential new habitable worlds...",
            imageUrl = "https://picsum.photos/400/300?random=2",
            author = "Michael Chen",
            date = "2025-04-14",
            content = "Using advanced machine learning algorithms...",
            category = NewsCategory.BREAKING_NEWS
        ),
        NewsItem(
            id = "3",
            title = "Global Markets React to New Trade Policies",
            description = "International markets show mixed reactions...",
            imageUrl = "https://picsum.photos/400/300?random=3",
            author = "Emma Wilson",
            date = "2025-04-14",
            content = "Stock markets across Asia and Europe...",
            category = NewsCategory.BREAKING_NEWS
        )
    )

    fun getLatestStories(): List<NewsItem> = listOf(
        NewsItem(
            id = "4",
            title = "Tech Giants Announce Breakthrough in Quantum Computing",
            description = "Major advancement in quantum processing...",
            imageUrl = "https://picsum.photos/400/300?random=4",
            author = "David Lee",
            date = "2025-04-14",
            content = "In a groundbreaking announcement...",
            category = NewsCategory.LATEST_STORIES
        ),
        NewsItem(
            id = "5",
            title = "Climate Change Summit Reaches New Agreement",
            description = "Global leaders have reached a consensus...",
            imageUrl = "https://picsum.photos/400/300?random=5",
            author = "Sophia Martinez",
            date = "2025-04-14",
            content = "After weeks of negotiations...",
            category = NewsCategory.LATEST_STORIES
        )
    )

    fun getMagazineStories(): List<NewsItem> = listOf(
        NewsItem(
            id = "6",
            title = "The Future of Work: Remote or Office?",
            description = "Companies are rethinking their work policies...",
            imageUrl = "https://picsum.photos/400/300?random=6",
            author = "James Wilson",
            date = "2025-04-14",
            content = "The debate over remote work continues...",
            category = NewsCategory.MAGAZINE
        )
    )
} 
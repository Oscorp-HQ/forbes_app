package com.forbes.app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object BookmarkRepository {
    // The single source of truth - just store IDs of bookmarked items
    private val bookmarkedItemIds = mutableSetOf<String>()
    
    // LiveData to observe bookmarked item IDs
    private val _bookmarkedIds = MutableLiveData<Set<String>>(emptySet())
    val bookmarkedIds: LiveData<Set<String>> = _bookmarkedIds
    
    // Toggle bookmark status for an item
    fun toggleBookmark(itemId: String) {
        if (bookmarkedItemIds.contains(itemId)) {
            // Remove from bookmarks
            bookmarkedItemIds.remove(itemId)
        } else {
            // Add to bookmarks
            bookmarkedItemIds.add(itemId)
        }
        
        // Update LiveData
        _bookmarkedIds.value = bookmarkedItemIds.toSet()
        
        // Debug log
        System.out.println("Bookmarked IDs: $bookmarkedItemIds")
    }
    
    // Check if an item is bookmarked
    fun isBookmarked(itemId: String): Boolean {
        return bookmarkedItemIds.contains(itemId)
    }
    
    // Get all bookmarked IDs as a list
    fun getBookmarkedIds(): List<String> {
        return bookmarkedItemIds.toList()
    }
} 
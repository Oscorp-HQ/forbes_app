package com.forbes.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.forbes.app.R
import com.forbes.app.model.NewsItem

class BookmarkedStoriesAdapter(
    private val onItemClick: (NewsItem) -> Unit,
    private val onBookmarkClick: (NewsItem) -> Unit
) : RecyclerView.Adapter<BookmarkedStoriesAdapter.ViewHolder>() {

    private var items: MutableList<NewsItem> = mutableListOf()

    fun submitList(newItems: List<NewsItem>) {
        // The items should already be filtered to only bookmarked ones
        System.out.println("Bookmarked adapter received ${newItems.size} items")
        items = newItems.toMutableList()
        notifyDataSetChanged()
    }
    
    fun removeItem(position: Int) {
        if (position >= 0 && position < items.size) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bookmarked_story, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.story_image)
        private val titleView: TextView = itemView.findViewById(R.id.story_title)
        private val authorView: TextView = itemView.findViewById(R.id.story_author)
        private val bookmarkButton: ImageButton = itemView.findViewById(R.id.bookmark_button)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(items[position])
                }
            }

            bookmarkButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // First remove from the UI
                    val newsItem = items[position]
                    removeItem(position)
                    // Then update bookmark status
                    onBookmarkClick(newsItem)
                }
            }
        }

        fun bind(item: NewsItem) {
            titleView.text = item.title
            authorView.text = "By ${item.author}"
            
            // Bookmark icons in this adapter are always filled since this is the bookmarks list
            bookmarkButton.setImageResource(R.drawable.ic_bookmark_filled)
            
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }
} 
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
import com.forbes.app.repository.BookmarkRepository

class LatestStoriesAdapter(
    private val onItemClick: (NewsItem) -> Unit,
    private val onBookmarkClick: (NewsItem) -> Unit
) : RecyclerView.Adapter<LatestStoriesAdapter.ViewHolder>() {

    private var items: List<NewsItem> = emptyList()

    fun submitList(newItems: List<NewsItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_latest_story, parent, false)
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
                    onBookmarkClick(items[position])
                }
            }
        }

        fun bind(item: NewsItem) {
            titleView.text = item.title
            authorView.text = "By ${item.author}"
            
            // Update bookmark icon based on repository
            val isBookmarked = BookmarkRepository.isBookmarked(item.id)
            bookmarkButton.setImageResource(
                if (isBookmarked) R.drawable.ic_bookmark_filled
                else R.drawable.ic_bookmark_border
            )
            
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }
} 
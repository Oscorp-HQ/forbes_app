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

class BreakingNewsAdapter(
    private val onItemClick: (NewsItem) -> Unit,
    private val onBookmarkClick: (NewsItem) -> Unit
) : RecyclerView.Adapter<BreakingNewsAdapter.NewsViewHolder>() {

    private var items: List<NewsItem> = emptyList()

    fun submitList(newItems: List<NewsItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_breaking_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.news_image)
        private val titleView: TextView = itemView.findViewById(R.id.news_title)
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
            
            // Update bookmark icon based on repository
            val isBookmarked = BookmarkRepository.isBookmarked(item.id)
            bookmarkButton.setImageResource(
                if (isBookmarked) R.drawable.ic_bookmark_filled
                else R.drawable.ic_bookmark_border
            )
            
            // Load image with Glide and handle errors
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }
} 
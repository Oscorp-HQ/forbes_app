package com.forbes.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.forbes.app.R
import com.forbes.app.databinding.ItemMagazineBinding
import com.forbes.app.model.Magazine

class MagazineAdapter(private val onItemClick: (Magazine) -> Unit) :
    ListAdapter<Magazine, MagazineAdapter.MagazineViewHolder>(MagazineDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineViewHolder {
        val binding = ItemMagazineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MagazineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MagazineViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MagazineViewHolder(private val binding: ItemMagazineBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(getItem(position))
                }
            }
        }

        fun bind(magazine: Magazine) {
            binding.apply {
                magazineTitle.text = magazine.title
                magazineDescription.text = magazine.description
                magazineDate.text = magazine.date
                
                Glide.with(magazineCover.context)
                    .load(magazine.imageUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .into(magazineCover)
            }
        }
    }

    private class MagazineDiffCallback : DiffUtil.ItemCallback<Magazine>() {
        override fun areItemsTheSame(oldItem: Magazine, newItem: Magazine): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Magazine, newItem: Magazine): Boolean {
            return oldItem == newItem
        }
    }
} 
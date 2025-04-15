package com.forbes.app.model

import java.io.Serializable

data class Magazine(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val author: String,
    val date: String,
    val content: String
) : Serializable 
package com.example.jobko.HomeAndJobDetails

import com.example.jobko.R

data class ReviewModel(
    val userName: String,
    val timeAgo: String,
    val reviewText: String,
    val userImage: Int,
    val rating: Int
)

val dummyReviews = listOf(
    ReviewModel(
        "George",
        "10 min ago",
        "Google is a fantastic multinational company. It focusing on search engine technology, web application software, quantum computing. I love this company",
        R.drawable.atif,
        5
    ),
    ReviewModel(
        "Thomas",
        "3 hr ago",
        "Google is a fantastic multinational company. It focusing on search engine technology, web application software, quantum computing. I love this company",
        R.drawable.profile_sample,
        5
    ),
    ReviewModel(
        "Jenny",
        "1 day ago",
        "Google is a fantastic multinational company. It focusing on search engine technology, web application software, quantum computing. I love this company",
        R.drawable.atif,
        5
    ),
    ReviewModel(
        "Emily",
        "1 day ago",
        "Google is a fantastic multinational company. It focusing on search engine technology, web application software, quantum computing. I love this company",
        R.drawable.jenny,
        5
    ),
    ReviewModel(
        "Grace",
        "1 day ago",
        "Google is a fantastic multinational company. It focusing on search engine technology, web application software, quantum computing. I love this company",
        R.drawable.jenny,
        5
    )
)
package com.example.jobko.HomeAndJobDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobko.R
import kotlin.collections.addAll
import kotlin.text.clear

class ReviewAdapter(private val reviewList: List<ReviewModel>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgUser: ImageView = view.findViewById(R.id.imgUserReview)
        val txtName: TextView = view.findViewById(R.id.txtReviewUserName)
        val txtTime: TextView = view.findViewById(R.id.txtReviewTime)
        val txtDesc: TextView = view.findViewById(R.id.txtReviewDescription)
        val starsLayout: LinearLayout = view.findViewById(R.id.reviewStarsLayout)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviewList[position]

        holder.txtName.text = review.userName
        holder.txtTime.text = "• ${review.timeAgo}"
        holder.txtDesc.text = "\"${review.reviewText}\""
        holder.imgUser.setImageResource(review.userImage)
    }

    override fun getItemCount(): Int = reviewList.size
}
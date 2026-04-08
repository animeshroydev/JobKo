package com.example.jobko.HomeAndJobDetails


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobko.R
import com.google.android.material.card.MaterialCardView

class RecentJobsAdapter(private val jobList: List<RecentJobModel>) :
    RecyclerView.Adapter<RecentJobsAdapter.JobViewHolder>() {

    class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val companyName: TextView = view.findViewById(R.id.companyName)
        val jobTitle: TextView = view.findViewById(R.id.jobTitleRecent)

        val countryName: TextView = view.findViewById(R.id.countryName)

        val logoCompany: ImageView = view.findViewById(R.id.companyLogoRecent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_job, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]


        holder.companyName.text = job.companyName
        holder.jobTitle.text = job.jobTitle
        holder.countryName.text = job.country
        holder.logoCompany.setImageResource(job.companyLogo)
    }

    override fun getItemCount(): Int = jobList.size
}
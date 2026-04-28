package com.example.jobko.HomeAndJobDetails


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobko.R

class SuggestedJobsAdapter(private val jobList: List<JobModel>,
                           private val onItemClick: (JobModel) -> Unit) :
    RecyclerView.Adapter<SuggestedJobsAdapter.JobViewHolder>() {

    class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val rootCard: com.google.android.material.card.MaterialCardView = view as com.google.android.material.card.MaterialCardView

        val companyName: TextView = view.findViewById(R.id.txtCompanyName)
        val jobTitle: TextView = view.findViewById(R.id.txtJobTitle)
        val salary: TextView = view.findViewById(R.id.txtSalary)
        val logo: ImageView = view.findViewById(R.id.imgCompanyLogo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal_home, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]

        // Set the background color dynamically
        holder.rootCard.setCardBackgroundColor(android.graphics.Color.parseColor(job.cardBgColor))

        holder.companyName.text = job.companyName
        holder.jobTitle.text = job.jobTitle
        holder.salary.text = job.salary
        holder.logo.setImageResource(job.companyLogo)

        holder.itemView.setOnClickListener {
            onItemClick(job)
        }
    }

    override fun getItemCount(): Int = jobList.size
}
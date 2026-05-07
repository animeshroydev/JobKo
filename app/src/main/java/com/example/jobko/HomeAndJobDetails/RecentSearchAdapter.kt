package com.example.jobko.HomeAndJobDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobko.R

class RecentSearchAdapter(private val searchList: List<String>, private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<RecentSearchAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtSearchQuery: TextView = view.findViewById(R.id.txtSearchQuery)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_search, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val query = searchList[position]
        holder.txtSearchQuery.text = query
        holder.itemView.setOnClickListener { onItemClick(query) }
    }

    override fun getItemCount(): Int = searchList.size
}
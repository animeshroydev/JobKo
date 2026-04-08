package com.example.jobko.HomeAndJobDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobko.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvSuggestedJobs = view.findViewById<RecyclerView>(R.id.rvSuggestedJobs)


        val jobList = listOf(
            JobModel("Google LLC", "Sr. UX Designer", "$195,000/ Year", R.drawable.google2, "#7C5CF0"),
            JobModel("Meta", "Product Designer", "$180,000/ Year", R.drawable.meta, "#4267B2"),
            JobModel("Microsoft", "UI Designer", "$160,000/ Year", R.drawable.microsoft, "#FF9900")
        )

        rvSuggestedJobs.layoutManager =
            LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )

        val adapter = SuggestedJobsAdapter(jobList)
        rvSuggestedJobs.adapter = adapter
    }

}
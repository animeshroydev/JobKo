package com.example.jobko.HomeAndJobDetails

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            JobModel(
                "Google LLC",
                "Sr. UX Designer",
                "$195,000/ Year",
                R.drawable.google2,
                "#7C5CF0"
            ),
            JobModel("Meta", "Product Designer", "$180,000/ Year", R.drawable.meta, "#4267B2"),
            JobModel("Microsoft", "UI Designer", "$160,000/ Year", R.drawable.microsoft, "#FF9900")
        )

        rvSuggestedJobs.layoutManager =
            LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )

        val adapter = SuggestedJobsAdapter(jobList) { clickedJob ->

//            Toast.makeText(
//                requireContext(),
//                "Clicked: ${clickedJob.jobTitle} at ${clickedJob.companyName}",
//                Toast.LENGTH_SHORT
//            ).show()

             // can navigate here:
             val intent = Intent(requireContext(), JobDetailActivity::class.java)

            intent.putExtra("JOB_TITLE", clickedJob.jobTitle)
            startActivity(intent)
        }
        rvSuggestedJobs.adapter = adapter


        val rvRecentJobs = view.findViewById<RecyclerView>(R.id.recentJobs)


        val recentJobList = listOf(
            RecentJobModel(
                "Apple, Inc.",
                "Sr. Product Designer",
                "United States",
                R.drawable.apple2
            ),
            RecentJobModel(
                "Apple, Inc.",
                "Sr. UI/UX Designer",
                "Singapore",
                R.drawable.amplitude
            ),
            RecentJobModel(
                "Adobe",
                "Software Developer",
                "New York City",
                R.drawable.adobe
            ),
            RecentJobModel(
                "Wings",
                "Lead Digital Marketer",
                "Anywhere (Remote)",
                R.drawable.wings
            ),
            RecentJobModel(
                "Airbnb",
                "Full Stack Developer",
                "United Kingdom",
                R.drawable.airbnb
            )
        )

        rvRecentJobs.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter2 = RecentJobsAdapter(recentJobList)
        rvRecentJobs.adapter = adapter2

    }

}
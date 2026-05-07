package com.example.jobko.HomeAndJobDetails

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobko.FilterAndSearch.FilterAndSearchActivity
import com.example.jobko.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class  HomeFragment : Fragment() {

    lateinit var bottomNav: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvSuggestedJobs = view.findViewById<RecyclerView>(R.id.rvSuggestedJobs)
        val rvRecentJobs = view.findViewById<RecyclerView>(R.id.recentJobs)
        val searchBar = view.findViewById<EditText>(R.id.searchBar)
        val scrollView = view.findViewById<View>(R.id.scrollView)
        val recentSearchOverlay = view.findViewById<ConstraintLayout>(R.id.recentSearchOverlay)
        val rvRecentSearches = view.findViewById<RecyclerView>(R.id.rvRecentSearches)

        searchBar.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showRecentSearchOverlay(scrollView, recentSearchOverlay)
            }
        }

        searchBar.setOnClickListener {
            showRecentSearchOverlay(scrollView, recentSearchOverlay)
        }

        // Back navigation handler for the overlay
        val callback = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                hideRecentSearchOverlay(scrollView, recentSearchOverlay)
                searchBar.clearFocus()
                isEnabled = false
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        // Search Bar Touch Listener for Filter Icon
        searchBar.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = searchBar.compoundDrawables[2]
                if (drawableEnd != null) {
                    if (event.rawX >= (searchBar.right - drawableEnd.bounds.width() - searchBar.paddingEnd)) {
                        val intent = Intent(requireContext(), FilterAndSearchActivity::class.java)
                        startActivity(intent)
                        return@setOnTouchListener true
                    }
                }
                // If touched outside the filter icon, show overlay
                showRecentSearchOverlay(scrollView, recentSearchOverlay)
                callback.isEnabled = true
            }
            false
        }

        // Setup Recent Searches RecyclerView
        val dummyRecentSearches = listOf(
            "UI/UX Design",
            "Product Design",
            "Web Apps Designer",
            "Mobile Apps Designer",
            "Website Designer",
            "Graphic Designer"
        )
        rvRecentSearches.layoutManager = LinearLayoutManager(requireContext())
        rvRecentSearches.adapter = RecentSearchAdapter(dummyRecentSearches) { query ->
            searchBar.setText(query)
            hideRecentSearchOverlay(scrollView, recentSearchOverlay)
            searchBar.clearFocus()
            callback.isEnabled = false
        }


        val jobList = listOf(
            JobModel("Google LLC", "Sr. UX Designer", "$195,000/ Year", R.drawable.google2, "#7C5CF0"),
            JobModel("Meta", "Product Designer", "$180,000/ Year", R.drawable.meta, "#4267B2"),
            JobModel("Microsoft", "UI Designer", "$160,000/ Year", R.drawable.microsoft, "#FF9900")
        )
        rvSuggestedJobs.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvSuggestedJobs.adapter = SuggestedJobsAdapter(jobList) { clickedJob ->
            val intent = Intent(requireContext(), JobDetailActivity::class.java)
            intent.putExtra("JOB_TITLE", clickedJob.jobTitle)
            startActivity(intent)
        }

        // Setup Recent Jobs
        val recentJobList = listOf(
            RecentJobModel("Apple, Inc.", "Sr. Product Designer", "United States", R.drawable.apple2),
            RecentJobModel("Apple, Inc.", "Sr. UI/UX Designer", "Singapore", R.drawable.amplitude),
            RecentJobModel("Adobe", "Software Developer", "New York City", R.drawable.adobe),
            RecentJobModel("Wings", "Lead Digital Marketer", "Anywhere (Remote)", R.drawable.wings),
            RecentJobModel("Airbnb", "Full Stack Developer", "United Kingdom", R.drawable.airbnb)
        )
        rvRecentJobs.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvRecentJobs.adapter = RecentJobsAdapter(recentJobList)
    }

    private fun showRecentSearchOverlay(scrollView: View, overlay: View) {
        overlay.visibility = View.VISIBLE
        scrollView.visibility = View.GONE
    }

    private fun hideRecentSearchOverlay(scrollView: View, overlay: View) {
        overlay.visibility = View.GONE
        scrollView.visibility = View.VISIBLE
    }
}
package com.example.jobko.HomeAndJobDetails

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.jobko.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class JobDetailActivity : AppCompatActivity() {

    lateinit var applyBtn: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_job_detail)

        applyBtn = findViewById<MaterialButton>(R.id.btnApplyThisJob)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val jobTitle = intent.getStringExtra("JOB_TITLE")

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        val adapter = JobDetailPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Job Description"
                1 -> "Requirements"
                2 -> "Company"
                else -> "Review"
            }
        }.attach()

        applyBtn.setOnClickListener {
            // Toast.makeText(this, "Applied for $jobTitle", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ApplyJobActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.jobko

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(activity: FragmentActivity)
    : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OnboardingFragment(R.drawable.onboard_one, "Search Job Easier \nand More Effective.", "Make your experiece of searching job \nmore easier and effective.")
            1 -> OnboardingFragment(R.drawable.onboard_two, "Apply for job anywhere & anytime.", "Jobfil Makes You Apply For Job From Anywhere and Anytime.")
            else -> OnboardingFragment(R.drawable.onboard_three, "Help Find Right Job With Your Desire.", "Jobfil Can Help You Find Job With Your Desire.")
        }
    }
}
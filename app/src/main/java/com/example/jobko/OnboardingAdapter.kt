package com.example.jobko

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(activity: FragmentActivity)
    : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OnboardingFragment(R.drawable.logo, "Welcome", "Discover features")
            1 -> OnboardingFragment(R.drawable.logo, "Fast", "Super fast performance")
            else -> OnboardingFragment(R.drawable.logo, "Secure", "Your data is safe")
        }
    }
}
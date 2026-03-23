package com.example.jobko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class OnboardingFragment(
    private val imageRes: Int,
    private val titleText: String,
    private val descText: String
) : Fragment(R.layout.onboarding_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<ImageView>(R.id.image).setImageResource(imageRes)
        view.findViewById<TextView>(R.id.title).text = titleText
        view.findViewById<TextView>(R.id.description).text = descText
    }
}
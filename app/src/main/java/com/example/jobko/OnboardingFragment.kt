package com.example.jobko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class OnboardingFragment : Fragment(R.layout.onboarding_page) {

    companion object {
        private const val ARG_IMAGE_RES = "image_res"
        private const val ARG_TITLE_TEXT = "title_text"
        private const val ARG_DESC_TEXT = "desc_text"

        fun newInstance(imageRes: Int, titleText: String, descText: String): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RES, imageRes)
            args.putString(ARG_TITLE_TEXT, titleText)
            args.putString(ARG_DESC_TEXT, descText)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageRes = arguments?.getInt(ARG_IMAGE_RES) ?: 0
        val titleText = arguments?.getString(ARG_TITLE_TEXT) ?: ""
        val descText = arguments?.getString(ARG_DESC_TEXT) ?: ""

        view.findViewById<ImageView>(R.id.image).setImageResource(imageRes)
        view.findViewById<TextView>(R.id.title).text = titleText
        view.findViewById<TextView>(R.id.description).text = descText
    }
}
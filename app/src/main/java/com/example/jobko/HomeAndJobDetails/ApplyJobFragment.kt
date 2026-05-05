package com.example.jobko.HomeAndJobDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.jobko.R
import com.google.android.material.button.MaterialButton


class ApplyJobFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_apply_job, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<MaterialButton>(R.id.btnApplyThisJob22)

        button.setOnClickListener {
            if (savedInstanceState == null) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SuccessApplyJobFragment())
                    .commit()
            }
        }

    }

}
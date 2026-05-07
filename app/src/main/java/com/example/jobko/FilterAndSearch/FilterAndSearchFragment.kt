package com.example.jobko.FilterAndSearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.jobko.R
import com.google.android.material.slider.RangeSlider

class FilterAndSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_and_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etCategory = view.findViewById<EditText>(R.id.etCategory)
        val btnBack = view.findViewById<ImageButton>(R.id.btnBack)
        val salarySlider = view.findViewById<RangeSlider>(R.id.salarySlider)
        val txtSalaryRange = view.findViewById<TextView>(R.id.txtSalaryRangeValue)

        // Back Button Listener
        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Category Dropdown logic
        val categories = arrayOf("Design", "Tech", "Marketing", "HR", "Business")
        etCategory.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Choose your category")
                .setItems(categories) { _, which ->
                    etCategory.setText(categories[which])
                }
                .show()
        }

        // Salary Range Slider Listener
        salarySlider.addOnChangeListener { slider, _, _ ->
            val values = slider.values
            val min = values[0].toInt()
            val max = values[1].toInt()
            txtSalaryRange.text = "$${min}K - $${max}K"
        }
    }
}
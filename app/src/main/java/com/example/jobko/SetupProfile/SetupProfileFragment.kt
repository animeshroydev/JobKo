package com.example.jobko.SetupProfile

import android.app.DatePickerDialog
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.jobko.R
import com.example.jobko.ResetPassword.VerificationPinFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SetupProfileFragment : Fragment() {

    private var selectedImageUri: Uri? = null
    lateinit var continueBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setup_profile, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("image_uri", selectedImageUri)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genderField = view.findViewById<AutoCompleteTextView>(R.id.edtGender)
        val dobField = view.findViewById<EditText>(R.id.edtDateOfBirth)
        val imgProfile = view.findViewById<ImageView>(R.id.imgProfile)
        val imgLock = view.findViewById<ImageView>(R.id.imgLock)
        continueBtn = view.findViewById(R.id.continueBtn)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            arrayOf("Male", "Female")
        )

        genderField.setAdapter(adapter)
        genderField.setOnClickListener { genderField.showDropDown() }

        dobField.setOnClickListener {
            val calendar = Calendar.getInstance()

            val datePicker = DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    val selected = Calendar.getInstance()
                    selected.set(year, month, day)

                    val sdf = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())
                    dobField.setText(sdf.format(selected.time))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()
        }

        // img picker
         val imagePicker =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                uri?.let {
                    selectedImageUri = it
                    imgProfile.setImageURI(it)
                }
            }

        savedInstanceState?.getParcelable<Uri>("image_uri")?.let {
            selectedImageUri = it
            imgProfile.setImageURI(it)
        }

        imgLock.setOnClickListener {
            imagePicker.launch("image/*")
        }

        continueBtn.setOnClickListener {

            val fragment = InterestFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
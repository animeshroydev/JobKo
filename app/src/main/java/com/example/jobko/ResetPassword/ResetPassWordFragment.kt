package com.example.jobko.ResetPassword

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.jobko.R


class ResetPassWordFragment : Fragment() {

    val textPassword = "Password *"
    val cnfmTextPassword = "Confirm Password *"
    lateinit var txtPassword: TextView
    lateinit var CnfmPassword: TextView

    lateinit var confirmPassword: EditText
    lateinit var edtPassword: EditText

    private var isPasswordVisible1 = false
    private var isPasswordVisible2 = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(
            R.layout.fragment_reset_pass_word,
            container, false
        )


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spannablePassword = SpannableString(textPassword)
        val spannableCnfmPassword = SpannableString(cnfmTextPassword)

        txtPassword = view.findViewById(R.id.txtPassword)
        CnfmPassword = view.findViewById(R.id.CnfmTxtPassword)

        confirmPassword = view.findViewById(R.id.editPassword1)
        edtPassword = view.findViewById(R.id.confirmPassWordEditTxt)

        spannablePassword.setSpan(
            ForegroundColorSpan(Color.RED),
            textPassword.length - 1,
            textPassword.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        txtPassword.text = spannablePassword

        spannableCnfmPassword.setSpan(
            ForegroundColorSpan(Color.RED),
            cnfmTextPassword.length - 1,
            cnfmTextPassword.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        CnfmPassword.text = spannableCnfmPassword

        passwordToggleFirst()
        passwordToggleSecond()

    }

    private fun passwordToggleSecond() {
        confirmPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {

                val drawableEnd = confirmPassword.compoundDrawables[2]

                if (drawableEnd != null &&
                    event.rawX >= (confirmPassword.right - drawableEnd.bounds.width())
                ) {

                    if (isPasswordVisible2) {
                        confirmPassword.inputType =
                            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                        confirmPassword.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_password_resized,
                            0,
                            R.drawable.ic_eye_slash_password,
                            0
                        )
                    } else {
                        confirmPassword.inputType =
                            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

                        confirmPassword.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_password_resized,
                            0,
                            R.drawable.ic_eye_slash_password_visible,
                            0
                        )
                    }

                    confirmPassword.setSelection(confirmPassword.text.length)
                    isPasswordVisible2 = !isPasswordVisible2

                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    private fun passwordToggleFirst() {
        edtPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {

                val drawableEnd = edtPassword.compoundDrawables[2]

                if (drawableEnd != null &&
                    event.rawX >= (edtPassword.right - drawableEnd.bounds.width())
                ) {

                    if (isPasswordVisible1) {
                        edtPassword.inputType =
                            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                        edtPassword.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_password_resized,
                            0,
                            R.drawable.ic_eye_slash_password,
                            0
                        )
                    } else {
                        edtPassword.inputType =
                            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

                        edtPassword.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_password_resized,
                            0,
                            R.drawable.ic_eye_slash_password_visible,
                            0
                        )
                    }

                    edtPassword.setSelection(edtPassword.text.length)
                    isPasswordVisible1 = !isPasswordVisible1

                    return@setOnTouchListener true
                }
            }
            false
        }
    }

}
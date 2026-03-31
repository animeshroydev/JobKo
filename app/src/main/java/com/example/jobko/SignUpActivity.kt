package com.example.jobko

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobko.SetupProfile.SetupProfileActivity
import kotlin.jvm.java

class SignUpActivity : AppCompatActivity() {

    lateinit var edtPassword: EditText
    lateinit var confirmPassword: EditText

    lateinit var btnSignUp: Button
    private var isPasswordVisible1 = false
    private var isPasswordVisible2 = false
    lateinit var fullName: TextView
    lateinit var txtEmail: TextView
    lateinit var txtPassword: TextView
    lateinit var CnfmPassword: TextView
    val textFullName = "Full Name *"
    val textEmail = "Email *"
    val textPassword = "Password *"
    val cnfmTextPassword = "Confirm Password *"
    val spannableFullName = SpannableString(textFullName)
    val spannableEmail = SpannableString(textEmail)

    val spannablePassword = SpannableString(textPassword)
    val spannableCnfmPassword = SpannableString(cnfmTextPassword)

    lateinit var txtSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        WindowCompat.setDecorFitsSystemWindows(window, true) // fix(ui): ensure form scrolls above keyboard on input focus
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtSignIn = findViewById(R.id.txtSignIn)
        edtPassword = findViewById(R.id.editPassword1)
        confirmPassword = findViewById(R.id.confirmPassWordEditTxt)
        btnSignUp = findViewById(R.id.btnSignUp)

        addMandatoryAsteriskTextEnd()
        passwordToggleFirst()
        passwordToggleSecond()

        txtSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SetupProfileActivity::class.java)
            startActivity(intent)
        }
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

    private fun addMandatoryAsteriskTextEnd() {
        fullName = findViewById(R.id.txtFullName)
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)
        CnfmPassword = findViewById(R.id.CnfmTxtPassword)



        spannableFullName.setSpan(
            ForegroundColorSpan(Color.RED),
            textFullName.length - 1,
            textFullName.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        fullName.text = spannableFullName

        spannableEmail.setSpan(
            ForegroundColorSpan(Color.RED),
            textEmail.length - 1,
            textEmail.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        txtEmail.text = spannableEmail

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
    }
}

package com.example.jobko

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtSignIn = findViewById(R.id.txtSignIn)

        addMandatoryAsteriskTextEnd()

        txtSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
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
package com.example.jobko

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.MotionEvent
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    lateinit var edtPassword: EditText
    lateinit var txtSignUp: TextView
    private var isPasswordVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        edtPassword = findViewById(R.id.eyeSlashUnfocused)
        txtSignUp = findViewById(R.id.txtSignUp)
        txtSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }



        passwordToggle()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    private fun passwordToggle() {
        edtPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {

                val drawableEnd = edtPassword.compoundDrawables[2]

                if (drawableEnd != null &&
                    event.rawX >= (edtPassword.right - drawableEnd.bounds.width())
                ) {

                    if (isPasswordVisible) {
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
                    isPasswordVisible = !isPasswordVisible

                    return@setOnTouchListener true
                }
            }
            false
        }
    }
}
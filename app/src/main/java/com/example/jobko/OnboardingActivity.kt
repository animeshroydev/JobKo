package com.example.jobko

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    private val prefs by lazy { getSharedPreferences("app", MODE_PRIVATE) }
    private lateinit var btnNext: Button
    private lateinit var btnSkip: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = OnboardingAdapter(this)

        btnNext.setOnClickListener {
            if (viewPager.currentItem < 2) {
                viewPager.currentItem = viewPager.currentItem + 1
            } else {
                goToMain()
            }
        }

        btnSkip.setOnClickListener {
            goToMain()
        }
    }

    fun goToMain() {
        prefs.edit().putBoolean("seen_onboarding", true).apply()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
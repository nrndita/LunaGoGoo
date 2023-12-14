package com.example.lunatiket.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.transdarat
import com.example.lunatiket.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.transudara

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        txtFlight()
    }
    private fun txtFlight() {
        transudara.setOnClickListener {
            startActivity(Intent(this, FlightActivity::class.java))
        }
    }
}
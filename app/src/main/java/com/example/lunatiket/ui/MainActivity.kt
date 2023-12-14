package com.example.lunatiket.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lunatiket.data.local.AppDatabase
import com.example.lunatiket.databinding.ActivityMainBinding
import com.example.lunatiket.di.RoomModule
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.android.inject

//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
////    private lateinit var auth : FirebaseAuth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
////        auth = FirebaseAuth.getInstance()
//
//        binding.button1.setOnClickListener{
//            startActivity(Intent(this, LoginActivity::class.java))
//        }
//        binding.button2.setOnClickListener{
//            startActivity(Intent(this, RegisterActivity::class.java))
//        }
//
//
//        supportActionBar?.hide()
//    }
//    override fun onStart(){
//        super.onStart()
//        if(auth.currentUser != null){
//            Intent(this, HomeActivity::class.java).also {
//                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(it)
//            }
//        }
//    }
//}
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.example.lunatiket.databinding.ActivityMainBinding
//import com.example.lunatiket.ui.LoginActivity
//import com.example.lunatiket.ui.register.RegisterActivity
//import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val db: AppDatabase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        supportActionBar?.hide()
    }
}

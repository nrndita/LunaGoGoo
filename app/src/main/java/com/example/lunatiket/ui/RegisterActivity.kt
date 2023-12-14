package com.example.lunatiket.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lunatiket.data.local.entity.UserEntity
import com.example.lunatiket.databinding.ActivityRegisterBinding
import com.example.lunatiket.ui.register.RegisterViewModel
import org.koin.android.ext.android.inject

//class RegisterActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityRegisterBinding
//    private lateinit var auth : FirebaseAuth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        //auth
//        auth = FirebaseAuth.getInstance()
//
//        binding.button3.setOnClickListener {
//            val email = binding.edtEmail.text.toString().trim()
//            val password = binding.edtPassword.text.toString().trim()
//            registerUser(email, password)
//        }
//
//        supportActionBar?.hide()
//        btnBackRegisListener()
//        txtLoginListener()
//    }
//
//    private fun btnBackRegisListener() {
//        r_back.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//    }
//    private fun txtLoginListener() {
//        txt_signin.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
//        }
//    }
//    private fun registerUser(email: String, password: String){
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this){
//                if(it.isSuccessful){
//                    startActivity(Intent(this, LoginActivity::class.java))
//                    Toast.makeText(this, "Register berhasil!", Toast.LENGTH_SHORT).show()
//                }else{
//                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//    }
//}


class RegisterActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        observeData()
    }
    private fun observeData() {
        with(viewModel) {
            observeIsRegister().observe(this@RegisterActivity) { isSuccess ->
                if (isSuccess) {
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@RegisterActivity, "Email Sudah Terdaftar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun init() {
        binding.button3.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            // Log the values before inserting into the database
            Log.d("RegisterActivity", "Username: $username, Email: $email, Password: $password")

            val user = UserEntity(0, username, email, password)
            viewModel.insertUser(user)
        }
    }


}
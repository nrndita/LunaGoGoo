package com.example.lunatiket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.lunatiket.databinding.ActivityLoginBinding
import com.example.lunatiket.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_home.transudara
import kotlinx.android.synthetic.main.activity_login.button4
import org.koin.android.ext.android.inject

class LoginActivity: AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("login", "onCreate: ")
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("login", "onCreate: init")
        init()
        observeData()


    }

    private fun observeData() {
        Log.d("log", "observeData: ")
        with(viewModel){
            observeIsLogin().observe(this@LoginActivity){
                it.let{ data ->
                    if (data != null){
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@LoginActivity,"not found", Toast.LENGTH_SHORT).show()
                        showValidationError("Email atau password salah")
                    }
                }
            }
        }
    }

    private fun init() {
        Log.d("login", "onCreate: init222")
        with(binding){
            button4.setOnClickListener{
                if(email.text.isNullOrBlank()){
                    email.error = "Email Kosong"
                }
                if(password.text.isNullOrBlank()){
                    password.error = "Password Kosong"
                }

                if(!email.text.isNullOrBlank() && !password.text.isNullOrBlank()){
                    viewModel.getDataLogin(email.text.toString(), password.text.toString())
                } else {
                    showValidationError("Data Tidak Valid")
                }
            }

            register.setOnClickListener{
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
            l_back.setOnClickListener{
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showValidationError(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()

    }

}

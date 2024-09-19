package com.example.tugaspertemuan5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan5.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the data from MainActivity
        val username = intent.getStringExtra("USERNAME") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""
        val phone = intent.getStringExtra("PHONE") ?: ""
        val gender = intent.getStringExtra("GENDER") ?: ""

        // Logika untuk tombol login
        binding.btnLogin.setOnClickListener {
            val enteredUsername = binding.usernametext.text.toString().trim()
            val password = binding.Passwordtext.text.toString().trim()

            if (enteredUsername.isNotEmpty() && password.isNotEmpty()) {
                // Cek kredensial atau logika autentikasi lain
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                // Arahkan ke HomeActivity dengan data yang diterima
                val intent = Intent(this@LoginActivity, HomeActivity::class.java).apply {
                    putExtra("USERNAME", username)
                    putExtra("EMAIL", email)
                    putExtra("PHONE", phone)
                    putExtra("GENDER", gender)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }

        // Jika ingin menambahkan logika untuk mengarahkan ke halaman registrasi dari login activity
        binding.newRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

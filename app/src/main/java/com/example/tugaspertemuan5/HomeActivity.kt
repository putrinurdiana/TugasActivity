package com.example.tugaspertemuan5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan5.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the data from LoginActivity
        val username = intent.getStringExtra("USERNAME") ?: "User"
        val email = intent.getStringExtra("EMAIL") ?: "N/A"
        val phone = intent.getStringExtra("PHONE") ?: "N/A"
        val gender = intent.getStringExtra("GENDER") ?: "N/A"

        // Update the TextViews with the received data
        binding.newRegister.text = "Username: $username"
        binding.email1.text = "Email: $email"
        binding.phone1.text = "Phone: $phone"
        binding.textgender.text = " $gender"
    }
}

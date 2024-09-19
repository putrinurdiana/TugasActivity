package com.example.tugaspertemuan5

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi komponen UI dan set onClickListener untuk tombol Sign In
        binding.btnSignUp.setOnClickListener {
            Log.d(TAG, "Sign Up button clicked")  // Log ketika tombol diklik
            if (validateInput()) {
                Log.d(TAG, "Input validated successfully")  // Log ketika validasi berhasil
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                // Arahkan pengguna ke LoginActivity setelah registrasi berhasil
                val intent = Intent(this@MainActivity, LoginActivity::class.java).apply {
                    putExtra("USERNAME", binding.usernameField.text.toString().trim())
                    putExtra("EMAIL", binding.emailField.text.toString().trim())
                    putExtra("PHONE", binding.phoneField.text.toString().trim())
                }
                startActivity(intent)
            } else {
                Log.d(TAG, "Input validation failed")  // Log jika validasi gagal
            }
        }
        binding.login.setOnClickListener {
            // Arahkan pengguna ke LoginActivity ketika teks login diklik
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk memvalidasi input pengguna
    private fun validateInput(): Boolean {
        val username = binding.usernameField.text.toString().trim()
        val email = binding.emailField.text.toString().trim()
        val phone = binding.phoneField.text.toString().trim()
        val password = binding.passwordField.text.toString().trim()

        // Cek apakah semua input tidak kosong
        Log.d(TAG, "Validating input")  // Log ketika mulai validasi

        if (TextUtils.isEmpty(username)) {
            binding.usernameField.error = "Username cannot be empty"
            Log.e(TAG, "Username is empty")  // Log error jika username kosong
            Toast.makeText(this, "Please enter a valid username", Toast.LENGTH_SHORT).show()
            return false
        }

        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailField.error = "Please enter a valid email"
            Log.e(TAG, "Invalid email: $email")  // Log error jika email tidak valid
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (TextUtils.isEmpty(phone) || !phone.matches(Regex("^[0-9]{10,12}\$"))) {
            binding.phoneField.error = "Please enter a valid phone number"
            Log.e(TAG, "Invalid phone number: $phone")  // Log error jika nomor telepon tidak valid
            Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
            return false
        }

        if (TextUtils.isEmpty(password) || password.length < 6) {
            binding.passwordField.error = "Password must be at least 6 characters"
            Log.e(TAG, "Invalid password: $password")  // Log error jika password kurang dari 6 karakter
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            return false
        }

        // Cek apakah checkbox persetujuan telah dicentang
        if (!binding.checkBox.isChecked) {
            Log.e(TAG, "Terms and conditions not accepted")  // Log jika checkbox tidak dicentang
            Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            return false
        }

        Log.d(TAG, "All input fields are valid")  // Log jika semua input valid
        return true


    }
}

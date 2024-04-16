package com.example.abedprojectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.abedprojectuts.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            Toast.makeText (this, "halaman recyclerview", Toast.LENGTH_SHORT).show()
        }

        binding.textRegister.setOnClickListener{
            val intent1 = Intent(this,RegisterActivity::class.java)
            startActivity(intent1)
            Toast.makeText (this, "halaman register", Toast.LENGTH_SHORT).show()
        }
        binding.tvForgetpass.setOnClickListener{
            val intent2 = Intent(this,ForgetActivity::class.java)
            startActivity(intent2)
            Toast.makeText (this, "halaman lupa password", Toast.LENGTH_SHORT).show()
        }


    }
}
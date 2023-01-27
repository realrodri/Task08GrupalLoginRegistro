package com.example.task08grupalloginregistro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task08grupalloginregistro.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var users = HashMap<String, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
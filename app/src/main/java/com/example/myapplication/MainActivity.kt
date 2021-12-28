package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val userSubmitted = submit()

            // called function with param
            bindResult(userSubmitted)
        }

        binding.btnReset.setOnClickListener {
            reset()
        }
    }

    // how to create a function
    // fun <function name>(<optional param>) : <obj> {
    //
    // }

    fun submit() : User {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        return User(email, password)
    }

    fun bindResult(user: User) {
        binding.tvEmail.text = user.email
        binding.tvPassword.text = user.password
    }

    fun reset() {
        binding.etEmail.setText("")
        binding.etPassword.setText("")
        binding.tvEmail.text = ""
        binding.tvPassword.text = ""
    }
}
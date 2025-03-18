package com.example.sesion3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sesion3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sayhi.setOnClickListener {
            val name = binding.name.text.toString()
            binding.greeting.text = "Hello: $name"
            Toast.makeText(baseContext, "Hello: $name", Toast.LENGTH_LONG ).show()
        }
        binding.toNext.setOnClickListener {
            val i = Intent(baseContext, GreetingActivity::class.java)
            i.putExtra("name", binding.name.text.toString())
            startActivity(i)
        }
    }
}
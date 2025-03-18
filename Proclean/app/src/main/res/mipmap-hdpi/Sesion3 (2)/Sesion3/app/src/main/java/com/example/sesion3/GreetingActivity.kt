package com.example.sesion3

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sesion3.databinding.ActivityGreetingBinding

class GreetingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGreetingBinding
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreetingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("name")
        Log.e("TAG", "Name recieved: $name")
        binding.greeting.text = "Hello $name"

        binding.addView.setOnClickListener {
            Log.i("TAG", "Counter: $counter")
            counter++
            var tv = TextView(baseContext)
            tv.text = "Vista $counter"
            binding.list.addView(tv)
        }
    }
}
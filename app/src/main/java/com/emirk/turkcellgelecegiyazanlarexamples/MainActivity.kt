package com.emirk.turkcellgelecegiyazanlarexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emirk.turkcellgelecegiyazanlarexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            count += 1
            binding.tvCounter.text = count.toString()
        }
    }
}
package com.emirk.mylibrary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emirk.mylibrary.databinding.ActivityMyLibraryBinding

class MyLibraryActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMyLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGoToApp.setOnClickListener{
            val intent = Intent(applicationContext, Class.forName("com.example.myapp.MainActivity"))
            applicationContext.startActivity(intent)
        }
    }
}
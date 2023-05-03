package com.emirk.mylibrary

import android.content.Intent
import android.net.Uri
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
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("myapp://app"))
            startActivity(intent)
        }//deeplink activity yöntemiyle açtır scheme manifeste tanımla  
    }
}
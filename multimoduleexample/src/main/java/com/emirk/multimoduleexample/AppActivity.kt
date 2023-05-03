package com.emirk.multimoduleexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emirk.multimoduleexample.databinding.ActivityAppBinding
import com.emirk.mylibrary.MyLibraryActivity

class AppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoToLibrary.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("myapp://library"))
            startActivity(intent)
        }
    }
}

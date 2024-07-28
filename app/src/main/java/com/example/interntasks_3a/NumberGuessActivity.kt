package com.example.interntasks_3a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interntasks_3a.databinding.ActivityNumberGuessBinding

class NumberGuessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNumberGuessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNumberGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
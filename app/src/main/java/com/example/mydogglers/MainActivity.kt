package com.example.mydogglers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mydogglers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.horizontalBtn.setOnClickListener { launchHorizontal() }

        binding.verticalBtn.setOnClickListener { launchVertical() }

        binding.gridBtn.setOnClickListener { launchGrid() }
    }

    private fun launchHorizontal() {
        val listIntent = Intent(this, HorizontalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchVertical() {
        val listIntent = Intent(this, VerticalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchGrid() {
        val listIntent = Intent(this, GridListActivity::class.java)
        startActivity(listIntent)
    }
}
package com.itxtest.rickandmorty.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itxtest.rickandmorty.platform.app.ApplicationClass
import com.itxtest.rickandmorty.platform.extension.gone
import com.itxtest.rickandmorty.platform.extension.visible
import com.itxtest.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationClass.currentActivity = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showLoading() {
        binding.loadingLayout.visible()
    }

    fun hideLoading() {
        binding.loadingLayout.gone()
    }

    fun showErrorOverlay() {
        binding.loadingLayout.visible()
    }
}

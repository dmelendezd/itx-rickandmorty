package com.itxtest.rickandmorty.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itxtest.rickandmorty.business.model.navigation.NavigationManager
import com.itxtest.rickandmorty.platform.app.ApplicationClass
import com.itxtest.rickandmorty.platform.extension.gone
import com.itxtest.rickandmorty.platform.extension.visible
import com.itxtest.rickandmorty.databinding.ActivityMainBinding
import com.itxtest.rickandmorty.main.presenter.MainLauncherPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainLauncherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ApplicationClass.currentActivity = this
        NavigationManager.getInstance().fragmentManager = supportFragmentManager
        binding = ActivityMainBinding.inflate(layoutInflater)
        presenter = MainLauncherPresenter()
        setContentView(binding.root)
        presenter.onViewInitialized()
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

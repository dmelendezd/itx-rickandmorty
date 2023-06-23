package com.itxtest.rickandmorty.view.main.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.itxtest.rickandmorty.R
import com.itxtest.rickandmorty.view.navigation.NavigationManager
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass
import com.itxtest.rickandmorty.view.platform.extension.visible
import com.itxtest.rickandmorty.databinding.ActivityMainBinding
import com.itxtest.rickandmorty.view.main.presenter.MainLauncherPresenter

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item_help) {
            presenter.onHelpClicked()
        }
        return super.onOptionsItemSelected(item)
    }

    fun showLoading() {
        binding.loadingView.show()
    }

    fun hideLoading() {
        binding.loadingView.hide()
    }

    fun showErrorOverlay() {
        binding.errorLayout.visible()
    }
}

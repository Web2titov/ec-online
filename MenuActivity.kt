package ru.electric.ec.online.ui.menu

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.electric.ec.online.R
import ru.electric.ec.online.databinding.MenuBinding

class MenuActivity : AppCompatActivity() {

    var viewModel: MenuItemViewModel? = null
    private var navigationModel: MenuViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MenuItemViewModel()
        val binding: MenuBinding = DataBindingUtil.setContentView(this, R.layout.menu)
        binding.viewModel = viewModel
        navigationModel = MenuViewModel(
            this, binding.drawer, binding.include.toolbar, binding.navigator
        )
        // Установить Toolbar для замены ActionBar
        setSupportActionBar(navigationModel!!.toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (navigationModel!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        navigationModel!!.actionBar.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        navigationModel!!.actionBar.onConfigurationChanged(newConfig)
    }
}
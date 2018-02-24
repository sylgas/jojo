package pl.lusy.jojo.journeyjournal.view.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_frame.*

import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.extension.snackbar
import pl.lusy.jojo.journeyjournal.extension.toast
import pl.lusy.jojo.journeyjournal.view.common.CoreActivity
import pl.lusy.jojo.journeyjournal.view.common.replaceContentWithFragment
import pl.lusy.jojo.journeyjournal.view.common.setupActionDrawer
import pl.lusy.jojo.journeyjournal.view.main.fragment.MainFragment
import pl.lusy.jojo.journeyjournal.view.welcome.WelcomeActivity

class MainActivity : CoreActivity() {
    private val navDrawerListener = NavDrawerListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActivityFrame()
        setupFragment()
        WelcomeActivity.start(this)
    }

    private fun setupActivityFrame() {
        setSupportActionBar(toolbar)
        setTitle(R.string.action_default_title)
        setupFabButton()
        setupNavDrawer()
    }

    private fun setupFragment() {
        replaceContentWithFragment(MainFragment.newInstance())
    }

    private fun setupFabButton() {
        fab.setOnClickListener { it.snackbar(R.string.not_yet_implemented) }
    }

    private fun setupNavDrawer() {
        setupActionDrawer(drawerLayout, toolbar)
        navView.setNavigationItemSelectedListener(navDrawerListener)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> handleActionSettings()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun handleActionSettings(): Boolean {
        toast(R.string.not_yet_implemented)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private inner class NavDrawerListener : NavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.nav_gallery -> {
                    toast(R.string.not_yet_implemented)
                }
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            return true
        }
    }
}

package pl.lusy.jojo.journeyjournal.view.main

import android.content.Context
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_drawer_view.*
import kotlinx.android.synthetic.main.toolbar_app.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.view.common.FrameCoreActivity
import pl.lusy.jojo.journeyjournal.view.common.replaceContentWithFragment
import pl.lusy.jojo.journeyjournal.view.common.setupActionDrawer
import pl.lusy.jojo.journeyjournal.view.common.startCustomActivity
import pl.lusy.jojo.journeyjournal.view.details.TripDetailsActivity
import pl.lusy.jojo.journeyjournal.view.main.fragment.MainFragment
import pl.lusy.jojo.journeyjournal.view.welcome.WelcomeActivity

class MainActivity : FrameCoreActivity() {
    companion object {
        fun start(context: Context) = context.startCustomActivity<MainActivity>()
    }

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
        fab.setOnClickListener { TripDetailsActivity.start(this) }
    }

    private fun setupNavDrawer() {
        setupActionDrawer(drawerLayout, toolbar)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        super.onNavigationItemSelected(item)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

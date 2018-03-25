package pl.lusy.jojo.journeyjournal.view.history

import android.content.Context
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.navigation_drawer_view.*
import kotlinx.android.synthetic.main.toolbar_bar.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.view.common.SearchNavigationCoreActivity
import pl.lusy.jojo.journeyjournal.view.common.replaceContentWithFragment
import pl.lusy.jojo.journeyjournal.view.common.setupActionDrawer
import pl.lusy.jojo.journeyjournal.view.common.startCustomActivity
import pl.lusy.jojo.journeyjournal.view.details.TripDetailsActivity
import pl.lusy.jojo.journeyjournal.view.history.fragment.HistoryFragment

class HistoryActivity : SearchNavigationCoreActivity() {
    companion object {
        fun start(context: Context) = context.startCustomActivity<HistoryActivity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setupActivityFrame()
        setupFragment()
    }

    private fun setupActivityFrame() {
        setSupportActionBar(toolbar)
        setupFabButton()
        setupNavDrawer()
    }

    private fun setupFragment() {
        replaceContentWithFragment(HistoryFragment.newInstance())
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

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
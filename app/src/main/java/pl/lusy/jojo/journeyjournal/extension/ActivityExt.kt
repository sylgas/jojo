package pl.lusy.jojo.journeyjournal.extension

import android.app.Activity
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import pl.lusy.jojo.journeyjournal.R

fun Activity.setupActionDrawer(drawerLayout: DrawerLayout, toolbar: Toolbar) {
    val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()
}
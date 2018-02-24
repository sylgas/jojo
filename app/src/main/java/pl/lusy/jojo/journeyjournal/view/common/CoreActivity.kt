package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import dagger.android.support.DaggerAppCompatActivity
import pl.lusy.jojo.journeyjournal.R

@SuppressLint("Registered")
open class CoreActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTaskDescriptionIfSupported()
    }

    private fun initTaskDescriptionIfSupported() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initTaskDescription()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initTaskDescription() {
        val taskColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val taskDescription = ActivityManager.TaskDescription(null, null, taskColor)
        setTaskDescription(taskDescription)
    }
}

fun CoreActivity.setupActionDrawer(drawerLayout: DrawerLayout, toolbar: Toolbar) {
    val toggle = ActionBarDrawerToggle(
        this, drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()
}

fun CoreActivity.replaceContentWithFragment(fragment: Fragment) {
    fragmentManager
        .beginTransaction()
        .replace(R.id.content, fragment)
        .commit()
}

inline fun <reified T : Activity> Context.startCustomActivity(bundle: Bundle? = null) =
    startActivity(Intent(this, T::class.java), bundle)

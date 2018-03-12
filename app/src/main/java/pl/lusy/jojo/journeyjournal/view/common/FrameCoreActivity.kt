package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.support.design.widget.NavigationView
import android.view.MenuItem
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.extension.toast

@SuppressLint("Registered")
abstract class FrameCoreActivity : CoreActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> handleActionSettings()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun handleActionSettings(): Boolean {
        toast(R.string.not_yet_implemented)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_gallery -> {
                toast(R.string.not_yet_implemented)
            }
        }
        return true
    }
}

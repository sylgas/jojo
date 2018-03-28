package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.support.design.widget.NavigationView
import android.view.MenuItem
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.view.history.HistoryActivity
import pl.lusy.jojo.journeyjournal.view.main.MainActivity

@SuppressLint("Registered")
abstract class NavigationCoreActivity : CoreActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_start -> {
                handleHomeSelect()
            }
            R.id.nav_history -> {
                handleHistorySelect()
            }
            R.id.nav_gallery -> {
                handleGallerySelect()
            }
            R.id.nav_settings -> {
                handleSettingsSelect()
            }
        }
        return true
    }

    private fun handleSettingsSelect() {
        toast(R.string.not_yet_implemented)

    }

    private fun handleGallerySelect() {
        toast(R.string.not_yet_implemented)
    }

    private fun handleHomeSelect() {
        MainActivity.start(this)
    }

    private fun handleHistorySelect() {
        HistoryActivity.start(this)
    }

}

package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.support.design.widget.NavigationView
import android.view.MenuItem
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.extension.toast
import pl.lusy.jojo.journeyjournal.view.main.MainActivity
import pl.lusy.jojo.journeyjournal.view.plan.TripPlanActivity

@SuppressLint("Registered")
abstract class NavigationCoreActivity : CoreActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_start -> {
                handleHomeSelect()
            }
            R.id.nav_all_trips -> {
                handleTripPlanSelect()
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
        MainActivity.start(this);
    }

    private fun handleTripPlanSelect() {
        TripPlanActivity.start(this)
    }

}

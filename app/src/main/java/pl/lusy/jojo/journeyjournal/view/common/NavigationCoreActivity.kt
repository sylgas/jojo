package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.support.design.widget.NavigationView
import android.view.MenuItem
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.extension.toast
import pl.lusy.jojo.journeyjournal.view.plan.TripPlanActivity

@SuppressLint("Registered")
abstract class NavigationCoreActivity : CoreActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_gallery -> {
                toast(R.string.not_yet_implemented)
            }
            R.id.nav_trip_plan -> {
                handleTripPlanSelect()
            }
        }
        return true
    }

    private fun handleTripPlanSelect() {
        TripPlanActivity.start(this)
    }

}

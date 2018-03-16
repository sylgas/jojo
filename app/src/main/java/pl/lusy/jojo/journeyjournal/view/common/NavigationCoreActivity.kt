package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.support.design.widget.NavigationView
import android.view.MenuItem
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.extension.toast

@SuppressLint("Registered")
abstract class NavigationCoreActivity : CoreActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_gallery -> {
                toast(R.string.not_yet_implemented)
            }
        }
        return true
    }

}

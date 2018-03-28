package pl.lusy.jojo.journeyjournal.view.common

import android.annotation.SuppressLint
import android.view.Menu
import android.view.MenuItem
import pl.lusy.jojo.journeyjournal.R

@SuppressLint("Registered")
abstract class SearchNavigationCoreActivity : NavigationCoreActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> handleActionSearch()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun handleActionSearch(): Boolean {
        toast(R.string.not_yet_implemented)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}

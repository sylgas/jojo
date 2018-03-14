package pl.lusy.jojo.journeyjournal.view.details

import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar_bar.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.view.common.CoreActivity
import pl.lusy.jojo.journeyjournal.view.common.replaceContentWithFragment
import pl.lusy.jojo.journeyjournal.view.common.startCustomActivity
import pl.lusy.jojo.journeyjournal.view.details.fragment.TripDetailsFragment

class TripDetailsActivity : CoreActivity() {
    companion object {
        fun start(context: Context) = context.startCustomActivity<TripDetailsActivity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)
        setupActivityFrame()
        setupFragment()
    }

    private fun setupActivityFrame() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupFragment() {
        replaceContentWithFragment(TripDetailsFragment.newInstance())
    }

}

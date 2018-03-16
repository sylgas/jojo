package pl.lusy.jojo.journeyjournal.view.details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar_bar_form.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.view.common.CoreActivity
import pl.lusy.jojo.journeyjournal.view.common.replaceContentWithFragment
import pl.lusy.jojo.journeyjournal.view.common.startCustomActivity
import pl.lusy.jojo.journeyjournal.view.details.fragment.TripDetailsFragment
import pl.lusy.jojo.journeyjournal.view.details.model.TripDetailsModel

class TripDetailsActivity : CoreActivity() {

    companion object {
        fun start(context: Context) = context.startCustomActivity<TripDetailsActivity>()
    }

    private val tripModel: TripDetailsModel by lazy {
        ViewModelProviders.of(this).get(TripDetailsModel::class.java)
    }

    private val tripNameWatcher = object : TextWatcher {
        override fun afterTextChanged(text: Editable?) {
            tripModel.onTripNameChange(text.toString())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)
        setupActivityFrame()
        setupFragment()
        setupViewListeners()
    }

    private fun setupViewListeners() {
        tripModel.tripName.observe(this, Observer<String?> { updateTripNameView(it) })
    }

    private fun updateTripNameView(name: String?) {
        tripName.setText(name)
        tripName.requestFocus()
        tripModel.tripName.removeObservers(this)
    }

    private fun setupActivityFrame() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_close)
        supportActionBar?.title = ""
        tripName.setTextLimit(R.integer.trip_details_name_limit)
        tripName.addTextChangedListener(tripNameWatcher)
        tripName.setTextLimitDetailsVisible(false)
    }

    private fun setupFragment() {
        replaceContentWithFragment(TripDetailsFragment.newInstance())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> handleActionSave()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun handleActionSave(): Boolean {
        tripModel.onSave()
        finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.form_menu, menu)
        return true
    }

}

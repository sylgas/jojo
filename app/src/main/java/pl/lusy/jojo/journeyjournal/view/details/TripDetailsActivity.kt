package pl.lusy.jojo.journeyjournal.view.details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
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
import pl.lusy.jojo.journeyjournal.view.common.toast
import pl.lusy.jojo.journeyjournal.view.details.fragment.TripDetailsFragment
import pl.lusy.jojo.journeyjournal.view.details.model.TripDetailsModel
import javax.inject.Inject

class TripDetailsActivity : CoreActivity() {

    companion object {
        private const val EXTRA_TRIP_ID = "EXTRA_TRIP_ID"

        fun start(context: Context, tripId: Long? = null) {
            val bundle = tripId?.let {
                Bundle().apply { putLong(EXTRA_TRIP_ID, tripId) }
            }
            context.startCustomActivity<TripDetailsActivity>(bundle)
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val tripModel: TripDetailsModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(TripDetailsModel::class.java)
    }

    private val tripNameWatcher = object : TextWatcher {
        override fun afterTextChanged(text: Editable?) {}

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            tripModel.onTripNameChange(text.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)
        setupActivityFrame()
        setupFragment()
        setupViewListeners()
    }

    private fun setupViewListeners() {
        tripModel.initTrip(intent?.extras?.getLong(EXTRA_TRIP_ID))
        tripModel.trip.observe(this, Observer { updateTripNameView(it?.name) })
        tripModel.errorMessage.observe(this, Observer { showError(it) })
    }

    private fun showError(errorMessage: String?) {
        errorMessage?.let { toast(it) }
    }

    private fun updateTripNameView(name: String?) {
        editableTitle.setText(name)
    }

    private fun setupActivityFrame() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_close)
        supportActionBar?.title = ""
        editableTitle.setTextLimit(R.integer.trip_details_name_limit)
        editableTitle.addTextChangedListener(tripNameWatcher)
        editableTitle.setTextLimitDetailsVisible(false)
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

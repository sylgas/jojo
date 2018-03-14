package pl.lusy.jojo.journeyjournal.view.details.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_trip_details.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.databinding.FragmentTripDetailsBinding
import pl.lusy.jojo.journeyjournal.view.details.model.TripDetailsModel

class TripDetailsFragment : DaggerFragment() {
    companion object {
        fun newInstance(): TripDetailsFragment = TripDetailsFragment()
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentTripDetailsBinding.inflate(inflater, container!!, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewListeners()
    }

    private fun setupView() {
        tripName.setTextLimit(R.integer.trip_details_name_limit)
        tripName.addTextChangedListener(tripNameWatcher)
    }

    private fun setupViewListeners() {
        tripModel.tripName.observe(this, Observer<String?> { updateTripNameView(it) })
    }

    private fun updateTripNameView(name: String?) {
        tripName.setText(name)
        tripName.requestFocus()
        tripModel.tripName.removeObservers(this)
    }
}
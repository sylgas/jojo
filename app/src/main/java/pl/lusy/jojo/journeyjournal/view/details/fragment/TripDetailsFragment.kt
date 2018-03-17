package pl.lusy.jojo.journeyjournal.view.details.fragment

import android.app.DatePickerDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_trip_details.*
import pl.lusy.jojo.journeyjournal.data.model.DayDate
import pl.lusy.jojo.journeyjournal.databinding.FragmentTripDetailsBinding
import pl.lusy.jojo.journeyjournal.view.details.model.TripDetailsModel

var TextView.dayDate: DayDate
    get() = DayDate.parse(text.toString())
    set(value) {
        text = value.toString()
    }

class TripDetailsFragment : DaggerFragment() {
    companion object {
        fun newInstance(): TripDetailsFragment = TripDetailsFragment()
    }

    private val tripModel: TripDetailsModel by lazy {
        ViewModelProviders.of(activity!!).get(TripDetailsModel::class.java)
    }

    private val startDateChangeListener =
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            tripModel.onTripStartDateSet(year, month, dayOfMonth)
        }

    private val endDateChangeListener =
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            tripModel.onTripEndDateSet(year, month, dayOfMonth)
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
        tripEndDate.setOnClickListener({
            showSelectDateDialog(tripEndDate.dayDate, endDateChangeListener)
        })
        tripStartDate.setOnClickListener({
            showSelectDateDialog(tripStartDate.dayDate, startDateChangeListener)
        })
    }

    private fun showSelectDateDialog(date: DayDate, listener: DatePickerDialog.OnDateSetListener) {
        DatePickerDialog(context, listener, date.year, date.month, date.day).show()
    }

    private fun setupViewListeners() {
        tripModel.tripStartDate.observe(this, Observer<DayDate?> {
            updateTripStartDate(it!!)
        })
        tripModel.tripEndDate.observe(this, Observer<DayDate?> {
            updateTripEndDate(it!!)
        })
    }

    private fun updateTripEndDate(date: DayDate) {
        tripEndDate.dayDate = date
    }

    private fun updateTripStartDate(date: DayDate) {
        tripStartDate.dayDate = date
    }
}
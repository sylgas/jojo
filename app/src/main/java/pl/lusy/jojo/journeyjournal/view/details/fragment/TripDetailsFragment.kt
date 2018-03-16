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
import pl.lusy.jojo.journeyjournal.databinding.FragmentTripDetailsBinding
import pl.lusy.jojo.journeyjournal.view.details.model.TripDetailsModel
import java.text.DateFormat
import java.util.*

var TextView.date: Date
    get() = DateFormat.getDateInstance().parse(text.toString())
    set(value) {
        text = DateFormat.getDateInstance().format(value)
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
            showSelectDateDialog(tripEndDate.date, endDateChangeListener)
        })
        tripStartDate.setOnClickListener({
            showSelectDateDialog(tripStartDate.date, startDateChangeListener)
        })
    }

    private fun showSelectDateDialog(date: Date, listener: DatePickerDialog.OnDateSetListener) {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(context, listener, year, month, dayOfMonth).show()
    }

    private fun setupViewListeners() {
        tripModel.tripStartDate.observe(this, Observer<Date?> { updateTripStartDate(it!!) })
        tripModel.tripEndDate.observe(this, Observer<Date?> { updateTripEndDate(it!!) })
    }

    private fun updateTripEndDate(date: Date) {
        tripEndDate.date = date
    }

    private fun updateTripStartDate(date: Date) {
        tripStartDate.date = date
    }
}
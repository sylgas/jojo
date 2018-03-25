package pl.lusy.jojo.journeyjournal.view.details.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import pl.lusy.jojo.journeyjournal.data.model.DayDate
import pl.lusy.jojo.journeyjournal.data.model.Trip
import pl.lusy.jojo.journeyjournal.data.repository.TripRepository
import pl.lusy.jojo.journeyjournal.view.common.model.Result
import pl.lusy.jojo.journeyjournal.view.common.model.toResult
import javax.inject.Inject

class TripDetailsModel @Inject constructor(
    private val repository: TripRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mutableErrorMessage: MutableLiveData<String?> = MutableLiveData()
    val errorMessage: LiveData<String?> = mutableErrorMessage

    private val mutableIsLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = mutableIsLoading

    private val mutableTrip : MutableLiveData<Trip> = MutableLiveData()
    val trip: LiveData<Trip> = mutableTrip

    init {
        mutableTrip.value = Trip()
    }

    fun initTrip(tripId: Long?) {
        tripId?.also { subscribeTrip(it) }
    }

    private fun subscribeTrip(tripId: Long) {
        repository.get(tripId).toResult().subscribeBy(onNext = { updateData(it) })
    }

    private fun updateData(result: Result<Trip>) {
        mutableErrorMessage.value = result.errorMessage
        mutableIsLoading.value = result.isLoading
        result.data?.also { mutableTrip.value = it }
    }

    fun onSave() {
        trip.value?.let {
            repository.save(it)
        }
    }

    fun onTripNameChange(name: String) {
        if (trip.value?.name != name) {
            mutableTrip.value = trip.value?.update(name = name)
        }
    }

    fun onTripStartDateChanged(year: Int, month: Int, dayOfMonth: Int) {
        val startDate = DayDate(dayOfMonth, month, year)
        if (trip.value?.startDate != startDate) {
            mutableTrip.value = trip.value?.update(startDate = startDate)
        }
    }

    fun onTripEndDateChanged(year: Int, month: Int, dayOfMonth: Int) {
        val endDate = DayDate(dayOfMonth, month, year)
        if (trip.value?.endDate != endDate) {
            mutableTrip.value = trip.value?.update(endDate = endDate)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
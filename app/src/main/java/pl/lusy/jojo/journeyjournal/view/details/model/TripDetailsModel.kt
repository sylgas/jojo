package pl.lusy.jojo.journeyjournal.view.details.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import pl.lusy.jojo.journeyjournal.data.prefs.TripData
import pl.lusy.jojo.journeyjournal.data.prefs.asSingle
import java.util.*

class TripDetailsModel : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mutableTripName: MutableLiveData<String> = MutableLiveData()
    val tripName: LiveData<String> = mutableTripName

    private val mutableTripStartDate: MutableLiveData<Date> = MutableLiveData()
    val tripStartDate: LiveData<Date> = mutableTripStartDate

    private val mutableTripEndDate: MutableLiveData<Date> = MutableLiveData()
    val tripEndDate: LiveData<Date> = mutableTripEndDate

    init {
        TripData.asSingle(TripData::name)
            .subscribeBy(onSuccess = {
                mutableTripName.value = it
            })
            .addTo(compositeDisposable)

        TripData.asSingle(TripData::startDate)
            .subscribeBy(onSuccess = {
                mutableTripStartDate.value = getDateFromMillis(it)
            })
            .addTo(compositeDisposable)

        TripData.asSingle(TripData::endDate)
            .subscribeBy(onSuccess = {
                mutableTripEndDate.value = getDateFromMillis(it)
            })
            .addTo(compositeDisposable)
    }

    private fun getDateFromMillis(milis: Long) = if (milis == 0L) Date() else Date(milis)

    fun onTripNameChange(name: String) {
        mutableTripName.value = name
    }

    fun onSave() {
        TripData.name = tripName.value ?: ""
        TripData.startDate = tripStartDate.value?.time ?: 0L
        TripData.endDate = tripEndDate.value?.time ?: 0L
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun onTripStartDateSet(year: Int, month: Int, dayOfMonth: Int) {
        mutableTripStartDate.value = getDate(year, month, dayOfMonth)
    }

    fun onTripEndDateSet(year: Int, month: Int, dayOfMonth: Int) {
        mutableTripEndDate.value = getDate(year, month, dayOfMonth)
    }

    fun getDate(year: Int, month: Int, dayOfMonth: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        return calendar.time
    }
}
package pl.lusy.jojo.journeyjournal.view.details.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import pl.lusy.jojo.journeyjournal.data.model.DayDate
import pl.lusy.jojo.journeyjournal.data.prefs.TripData
import pl.lusy.jojo.journeyjournal.data.prefs.asSingle

class TripDetailsModel : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mutableTripName: MutableLiveData<String> = MutableLiveData()
    val tripName: LiveData<String> = mutableTripName

    private val mutableTripStartDate: MutableLiveData<DayDate> = MutableLiveData()
    val tripStartDate: LiveData<DayDate> = mutableTripStartDate

    private val mutableTripEndDate: MutableLiveData<DayDate> = MutableLiveData()
    val tripEndDate: LiveData<DayDate> = mutableTripEndDate

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

    private fun getDateFromMillis(millis: Long) =
        if (millis == 0L) DayDate.getCurrentDate() else DayDate.fromMillis(millis)

    fun onTripNameChange(name: String) {
        mutableTripName.value = name
    }

    fun onSave() {
        TripData.name = tripName.value ?: ""
        TripData.startDate = tripStartDate.value?.millis ?: 0L
        TripData.endDate = tripEndDate.value?.millis ?: 0L
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun onTripStartDateSet(year: Int, month: Int, dayOfMonth: Int) {
        mutableTripStartDate.value = DayDate(dayOfMonth, month, year)
    }

    fun onTripEndDateSet(year: Int, month: Int, dayOfMonth: Int) {
        mutableTripEndDate.value = DayDate(dayOfMonth, month, year)
    }
}
package pl.lusy.jojo.journeyjournal.view.main.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import pl.lusy.jojo.journeyjournal.data.model.DayDate
import pl.lusy.jojo.journeyjournal.data.prefs.Preferences
import pl.lusy.jojo.journeyjournal.data.prefs.TripData
import pl.lusy.jojo.journeyjournal.data.prefs.asSingle

class MainViewModel : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mutableDisplayWelcomeScreen: MutableLiveData<Boolean> = MutableLiveData()
    val displayWelcomeScreen: LiveData<Boolean> = mutableDisplayWelcomeScreen

    private val mutableDisplayHistory: MutableLiveData<Boolean> = MutableLiveData()
    val displayHistory: LiveData<Boolean> = mutableDisplayHistory

    init {
        Preferences.asSingle(Preferences::displayWelcomeScreen)
            .subscribeBy(onSuccess = {
                mutableDisplayWelcomeScreen.value = it
            })
            .addTo(compositeDisposable)

        val startDateSingle = Preferences.asSingle(TripData::startDate)
        val endDateSingle = Preferences.asSingle(TripData::endDate)

        Single.zip(startDateSingle, endDateSingle,
            BiFunction<Long, Long, Boolean> { startDateTime, endDateTime ->
                isTripRunning(startDateTime, endDateTime)
            }).subscribeBy(onSuccess = {
            mutableDisplayHistory.value = it
        }).addTo(compositeDisposable)
    }

    private fun isTripRunning(startDateTime: Long, endDateTime: Long) =
        DayDate.getCurrentDate().millis in startDateTime..endDateTime

    fun onWelcomeScreenShown() {
        Preferences.displayWelcomeScreen = false
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

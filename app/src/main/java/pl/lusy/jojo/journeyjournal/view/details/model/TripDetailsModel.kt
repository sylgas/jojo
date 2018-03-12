package pl.lusy.jojo.journeyjournal.view.details.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import pl.lusy.jojo.journeyjournal.data.prefs.TripData
import pl.lusy.jojo.journeyjournal.data.prefs.asFlowable

class TripDetailsModel : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mutableTripName: MutableLiveData<String> = MutableLiveData()
    val tripName: LiveData<String> = mutableTripName

    init {
        TripData.asFlowable(TripData::name)
            .subscribeBy(onNext = {
                mutableTripName.value = it
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
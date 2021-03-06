package pl.lusy.jojo.journeyjournal.view.main.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import pl.lusy.jojo.journeyjournal.data.prefs.Preferences
import pl.lusy.jojo.journeyjournal.data.prefs.asSingle
import pl.lusy.jojo.journeyjournal.view.main.adapter.item.HomeItem
import pl.lusy.jojo.journeyjournal.view.main.adapter.item.LocationHomeItem
import pl.lusy.jojo.journeyjournal.view.main.adapter.item.PlanHomeItem
import pl.lusy.jojo.journeyjournal.view.main.adapter.item.TripHomeItem

class MainViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val mutableDisplayWelcomeScreen = MutableLiveData<Boolean>()
    val displayWelcomeScreen: LiveData<Boolean> = mutableDisplayWelcomeScreen

    private val mutableHomeItems = MutableLiveData<List<HomeItem>>()
    val homeItems: LiveData<List<HomeItem>> = mutableHomeItems

    init {
        mutableHomeItems.value = listOf(
            TripHomeItem(),
            PlanHomeItem(),
            LocationHomeItem()
        )
        Preferences.asSingle(Preferences::displayWelcomeScreen)
            .subscribeBy(onSuccess = {
                mutableDisplayWelcomeScreen.value = it
            })
            .addTo(compositeDisposable)
    }

    fun onWelcomeScreenShown() {
        Preferences.displayWelcomeScreen = false
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

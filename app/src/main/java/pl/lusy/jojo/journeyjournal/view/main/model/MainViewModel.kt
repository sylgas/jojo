package pl.lusy.jojo.journeyjournal.view.main.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import pl.lusy.jojo.journeyjournal.data.prefs.Preferences
import pl.lusy.jojo.journeyjournal.data.prefs.asSingle

class MainViewModel : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mutableDisplayWelcomeScreen: MutableLiveData<Boolean> = MutableLiveData()
    val displayWelcomeScreen: LiveData<Boolean> = mutableDisplayWelcomeScreen

    init {
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
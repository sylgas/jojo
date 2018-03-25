package pl.lusy.jojo.journeyjournal.view.history.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import pl.lusy.jojo.journeyjournal.data.model.Trip
import pl.lusy.jojo.journeyjournal.data.repository.TripRepository
import pl.lusy.jojo.journeyjournal.view.common.model.Result
import pl.lusy.jojo.journeyjournal.view.common.model.toResult
import pl.lusy.jojo.journeyjournal.view.plan.model.toLiveData
import javax.inject.Inject

class HistoryModel @Inject constructor(
    private val repository: TripRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val tripsResult: LiveData<Result<List<Trip>>> by lazy {
        repository.fetch().toResult().toLiveData()
    }

    val errorMessage = Transformations.map(tripsResult, { it.errorMessage })

    val trips = Transformations.map(tripsResult, { it.data })

    val isLoading = Transformations.map(tripsResult, { it.isLoading })

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
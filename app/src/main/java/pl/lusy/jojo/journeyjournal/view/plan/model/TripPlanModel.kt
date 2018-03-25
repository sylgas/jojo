package pl.lusy.jojo.journeyjournal.view.plan.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import org.reactivestreams.Publisher
import pl.lusy.jojo.journeyjournal.data.repository.PlanRepository
import pl.lusy.jojo.journeyjournal.view.common.model.toResult
import javax.inject.Inject


class TripPlanModel @Inject constructor(
    private val repository: PlanRepository
) : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val plan by lazy { repository.get(0L).toResult().toLiveData() }

    val errorMessage = Transformations.map(plan, { it.errorMessage })

    val planSteps = Transformations.map(plan, { it.data?.steps })

    val isLoading = Transformations.map(plan, { it.isLoading })
}

fun <T> Publisher<T>.toLiveData() =
    LiveDataReactiveStreams.fromPublisher(this) as LiveData<T>

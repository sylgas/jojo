package pl.lusy.jojo.journeyjournal.inject.android.module.app

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.lusy.jojo.journeyjournal.inject.android.factory.ViewModelFactory
import pl.lusy.jojo.journeyjournal.inject.android.key.ViewModelKey
import pl.lusy.jojo.journeyjournal.view.details.model.TripDetailsModel
import pl.lusy.jojo.journeyjournal.view.history.model.HistoryModel
import pl.lusy.jojo.journeyjournal.view.plan.model.TripPlanModel

@Module
interface ViewModelBinderModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TripPlanModel::class)
    fun bindTripPlanModel(model: TripPlanModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TripDetailsModel::class)
    fun bindTripDetailsModel(model: TripDetailsModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryModel::class)
    fun bindHistoryModel(model: HistoryModel): ViewModel

}

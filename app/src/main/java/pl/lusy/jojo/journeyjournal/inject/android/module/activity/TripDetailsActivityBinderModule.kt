package pl.lusy.jojo.journeyjournal.inject.android.module.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.inject.android.scope.FragmentScope
import pl.lusy.jojo.journeyjournal.view.details.fragment.TripDetailsFragment

@Module
internal interface TripDetailsActivityBinderModule {
    @ContributesAndroidInjector
    @FragmentScope
    fun contributeTripDetailsFragment(): TripDetailsFragment
}

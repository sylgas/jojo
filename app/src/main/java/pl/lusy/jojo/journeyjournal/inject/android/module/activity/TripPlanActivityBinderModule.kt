package pl.lusy.jojo.journeyjournal.inject.android.module.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.inject.android.scope.FragmentScope
import pl.lusy.jojo.journeyjournal.view.plan.fragment.TripPlanFragment

@Module
internal interface TripPlanActivityBinderModule {
    @ContributesAndroidInjector
    @FragmentScope
    fun contributeTripPlanFragment(): TripPlanFragment
}

package pl.lusy.jojo.journeyjournal.inject.android.module.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.inject.android.scope.ActivityScope
import pl.lusy.jojo.journeyjournal.view.details.TripDetailsActivity
import pl.lusy.jojo.journeyjournal.view.history.HistoryActivity
import pl.lusy.jojo.journeyjournal.view.main.MainActivity
import pl.lusy.jojo.journeyjournal.view.plan.TripPlanActivity
import pl.lusy.jojo.journeyjournal.view.splash.SplashActivity
import pl.lusy.jojo.journeyjournal.view.welcome.WelcomeActivity

@Module
interface ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainActivityBinderModule::class])
    @ActivityScope
    fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [
        WelcomeActivityProviderModule::class,
        WelcomeActivityBinderModule::class
    ])
    @ActivityScope
    fun contributeWelcomeActivity(): WelcomeActivity

    @ContributesAndroidInjector
    @ActivityScope
    fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [TripDetailsActivityBinderModule::class])
    @ActivityScope
    fun contributeTripDetailsActivity(): TripDetailsActivity

    @ContributesAndroidInjector(modules = [HistoryActivityBinderModule::class])
    @ActivityScope
    fun contributeHistoryActivity(): HistoryActivity

    @ContributesAndroidInjector(modules = [TripPlanActivityBinderModule::class])
    @ActivityScope
    fun contributeTripPlanActivity(): TripPlanActivity
}

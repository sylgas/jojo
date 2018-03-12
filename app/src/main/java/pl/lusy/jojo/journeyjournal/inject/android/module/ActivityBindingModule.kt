package pl.lusy.jojo.journeyjournal.inject.android.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.inject.android.module.activity.MainActivityBinderModule
import pl.lusy.jojo.journeyjournal.inject.android.module.activity.TripDetailsActivityBinderModule
import pl.lusy.jojo.journeyjournal.inject.android.module.activity.WelcomeActivityBinderModule
import pl.lusy.jojo.journeyjournal.inject.android.module.activity.WelcomeActivityProviderModule
import pl.lusy.jojo.journeyjournal.inject.android.scope.ActivityScope
import pl.lusy.jojo.journeyjournal.view.details.TripDetailsActivity
import pl.lusy.jojo.journeyjournal.view.main.MainActivity
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
}

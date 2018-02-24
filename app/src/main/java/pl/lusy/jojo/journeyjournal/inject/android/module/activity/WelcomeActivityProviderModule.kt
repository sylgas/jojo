package pl.lusy.jojo.journeyjournal.inject.android.module.activity

import dagger.Module
import dagger.Provides
import pl.lusy.jojo.journeyjournal.inject.android.scope.ActivityScope
import pl.lusy.jojo.journeyjournal.view.welcome.WelcomeActivity
import pl.lusy.jojo.journeyjournal.view.welcome.adapter.WelcomePageAdapter
import pl.lusy.jojo.journeyjournal.view.welcome.enum.WelcomeStep
import pl.lusy.jojo.journeyjournal.view.welcome.fragment.WelcomePageFragment

@Module
internal class WelcomeActivityProviderModule {
    @Provides
    @ActivityScope
    fun provideWelcomePageAdapter(activity: WelcomeActivity, fragments: List<WelcomePageFragment>) =
        WelcomePageAdapter(activity.supportFragmentManager, fragments)

    @Provides
    @ActivityScope
    fun provideWelcomeStepFragments(): List<WelcomePageFragment> {
        return WelcomeStep.values().map { WelcomePageFragment.newInstance(it) }
    }
}
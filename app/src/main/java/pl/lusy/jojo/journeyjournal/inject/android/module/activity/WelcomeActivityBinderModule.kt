package pl.lusy.jojo.journeyjournal.inject.android.module.activity

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.inject.android.scope.ActivityScope
import pl.lusy.jojo.journeyjournal.inject.android.scope.FragmentScope
import pl.lusy.jojo.journeyjournal.view.common.CoreActivity
import pl.lusy.jojo.journeyjournal.view.welcome.WelcomeActivity
import pl.lusy.jojo.journeyjournal.view.welcome.fragment.WelcomeFragment

@Module
internal interface WelcomeActivityBinderModule {
    @Binds
    @ActivityScope
    fun providesCoreActivity(activity: WelcomeActivity): CoreActivity

    @ContributesAndroidInjector
    @FragmentScope
    fun contributeWelcomeFragment(): WelcomeFragment
}
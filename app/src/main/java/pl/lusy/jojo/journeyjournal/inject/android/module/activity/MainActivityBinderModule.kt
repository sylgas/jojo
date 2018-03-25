package pl.lusy.jojo.journeyjournal.inject.android.module.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.inject.android.scope.FragmentScope
import pl.lusy.jojo.journeyjournal.view.main.fragment.MainFragment

@Module
internal interface MainActivityBinderModule {
    @ContributesAndroidInjector
    @FragmentScope
    fun contributeMainFragment(): MainFragment
}
package pl.lusy.jojo.journeyjournal.inject.android.module.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.inject.android.scope.FragmentScope
import pl.lusy.jojo.journeyjournal.view.history.fragment.HistoryFragment

@Module
internal interface HistoryActivityBinderModule {
    @ContributesAndroidInjector
    @FragmentScope
    fun contributeHistoryFragment(): HistoryFragment
}

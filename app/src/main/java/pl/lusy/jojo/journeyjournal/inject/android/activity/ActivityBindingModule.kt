package pl.lusy.jojo.journeyjournal.inject.android.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.lusy.jojo.journeyjournal.view.main.MainActivity

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    internal abstract fun contributeMainActivity(): MainActivity
}

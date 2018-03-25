package pl.lusy.jojo.journeyjournal

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pl.lusy.jojo.journeyjournal.inject.DaggerAppComponent

class JourneyJournal : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)
}
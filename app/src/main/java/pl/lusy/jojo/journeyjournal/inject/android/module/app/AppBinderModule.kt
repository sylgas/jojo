package pl.lusy.jojo.journeyjournal.inject.android.module.app

import android.content.Context
import dagger.Binds
import dagger.Module
import pl.lusy.jojo.journeyjournal.JourneyJournal
import pl.lusy.jojo.journeyjournal.inject.android.scope.AppScope

@Module
interface AppBinderModule {
    @Binds
    @AppScope
    fun provideContext(application: JourneyJournal): Context
}
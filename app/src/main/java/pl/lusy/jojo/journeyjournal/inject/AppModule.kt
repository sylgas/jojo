package pl.lusy.jojo.journeyjournal.inject

import android.content.Context
import dagger.Binds
import dagger.Module
import pl.lusy.jojo.journeyjournal.JourneyJournal

@Module
interface AppModule {
    @Binds
    @AppScope
    fun provideContext(application: JourneyJournal): Context
}
package pl.lusy.jojo.journeyjournal.inject

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.lusy.jojo.journeyjournal.JourneyJournal
import pl.lusy.jojo.journeyjournal.inject.android.module.ActivityBindingModule

@AppScope
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class
])
interface AppComponent : AndroidInjector<JourneyJournal> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<JourneyJournal>()
}

package pl.lusy.jojo.journeyjournal.inject

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.lusy.jojo.journeyjournal.JourneyJournal
import pl.lusy.jojo.journeyjournal.inject.android.module.activity.ActivityBindingModule
import pl.lusy.jojo.journeyjournal.inject.android.module.app.AppBinderModule
import pl.lusy.jojo.journeyjournal.inject.android.module.app.AppProviderModule
import pl.lusy.jojo.journeyjournal.inject.android.module.app.DatabaseProviderModule
import pl.lusy.jojo.journeyjournal.inject.android.module.app.ViewModelBinderModule
import pl.lusy.jojo.journeyjournal.inject.android.scope.AppScope

@AppScope
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppBinderModule::class,
    AppProviderModule::class,
    DatabaseProviderModule::class,
    ViewModelBinderModule::class,
    ActivityBindingModule::class
])
interface AppComponent : AndroidInjector<JourneyJournal> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<JourneyJournal>()
}

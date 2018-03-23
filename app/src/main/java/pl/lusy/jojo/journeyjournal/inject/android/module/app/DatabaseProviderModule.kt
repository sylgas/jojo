package pl.lusy.jojo.journeyjournal.inject.android.module.app

import dagger.Module
import dagger.Provides
import pl.lusy.jojo.journeyjournal.data.db.PlanDatabase
import pl.lusy.jojo.journeyjournal.data.db.PlanRoomDatabase
import pl.lusy.jojo.journeyjournal.inject.android.scope.AppScope

@Module
internal class DatabaseProviderModule {
    @Provides
    @AppScope
    fun providePlanDatabase(): PlanDatabase = PlanRoomDatabase()
}
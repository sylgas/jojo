package pl.lusy.jojo.journeyjournal.inject.android.module.app

import dagger.Module
import dagger.Provides
import pl.lusy.jojo.journeyjournal.data.db.PlanDatabase
import pl.lusy.jojo.journeyjournal.data.repository.PlanDatabaseRepository
import pl.lusy.jojo.journeyjournal.data.repository.PlanRepository
import pl.lusy.jojo.journeyjournal.inject.android.scope.AppScope

@Module
internal class AppProviderModule {
    @Provides
    @AppScope
    fun providePlanRepository(database: PlanDatabase): PlanRepository =
        PlanDatabaseRepository(database)
}
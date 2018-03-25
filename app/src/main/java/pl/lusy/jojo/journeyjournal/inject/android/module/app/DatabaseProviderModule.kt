package pl.lusy.jojo.journeyjournal.inject.android.module.app

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.droidkaigi.confsched2018.data.db.LocalRoomDatabase
import pl.lusy.jojo.journeyjournal.data.db.PlanDatabase
import pl.lusy.jojo.journeyjournal.data.db.PlanRoomDatabase
import pl.lusy.jojo.journeyjournal.data.db.dao.PlanDao
import pl.lusy.jojo.journeyjournal.inject.android.scope.AppScope

@Module
internal class DatabaseProviderModule {

    @Provides
    @AppScope
    fun provideDatabase(context: Context): LocalRoomDatabase =
        Room.databaseBuilder(context, LocalRoomDatabase::class.java, "jojo.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @AppScope
    fun providePlanDatabase(planDao: PlanDao): PlanDatabase = PlanRoomDatabase(planDao)

    @Provides
    @AppScope
    fun providePlanDao(database: LocalRoomDatabase): PlanDao = database.getPlanDao()

}
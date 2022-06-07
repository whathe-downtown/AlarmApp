package com.example.alarmapp.di

import android.app.Application
import androidx.room.Room
import com.example.alarmapp.db.AlarmDatabase
import com.example.alarmapp.db.AlarmRepository
import com.example.alarmapp.db.AlarmRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideAlarmDatabase(app: Application) : AlarmDatabase{
        return Room.databaseBuilder(
            app,
            AlarmDatabase::class.java,
            "alarm_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAlarmRepository(db: AlarmDatabase): AlarmRepository{
        return AlarmRepositoryImpl(db.dao)
    }
}
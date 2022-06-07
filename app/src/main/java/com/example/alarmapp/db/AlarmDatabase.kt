package com.example.alarmapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alarmapp.db.dao.AlarmDao
import com.example.alarmapp.db.model.AlarmModel

@Database(
    entities = [AlarmModel::class],
    version =1
)
abstract class AlarmDatabase : RoomDatabase(){

    abstract val dao : AlarmDao
}
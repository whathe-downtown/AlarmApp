package com.example.alarmapp.db.dao

import androidx.room.*
import com.example.alarmapp.db.model.AlarmModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlarm(alarmModel: AlarmModel)

    @Delete
    suspend fun deleteAlarm(alarmModel: AlarmModel)

    @Query("SELECT * FROM alarm_table WHERE id = :id")
    suspend fun getAlarmModelById(id:Int) : AlarmModel?

    @Query("SELECT * FROM alarm_table ORDER BY id")
    fun getAllAlarm(): Flow<List<AlarmModel>>

}

package com.example.alarmapp.db

import com.example.alarmapp.db.model.AlarmModel
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {

    suspend fun insertAlarm(alarmModel: AlarmModel)

    suspend fun deleteAlarm(alarmModel: AlarmModel)

    suspend fun getAlarmById(id:Int) : AlarmModel?

    fun getAlarmModels() : Flow<List<AlarmModel>>
}
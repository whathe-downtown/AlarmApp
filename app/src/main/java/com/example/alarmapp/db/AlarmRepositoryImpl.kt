package com.example.alarmapp.db

import com.example.alarmapp.db.dao.AlarmDao
import com.example.alarmapp.db.model.AlarmModel
import kotlinx.coroutines.flow.Flow

class AlarmRepositoryImpl(
    private val dao: AlarmDao
): AlarmRepository {
    override suspend fun insertAlarm(alarmModel: AlarmModel) {
        dao.insertAlarm(alarmModel)
    }

    override suspend fun deleteAlarm(alarmModel: AlarmModel) {
        dao.deleteAlarm(alarmModel)
    }

    override suspend fun getAlarmById(id: Int): AlarmModel? {
        return dao.getAlarmModelById(id)
    }

    override fun getAlarmModels(): Flow<List<AlarmModel>> {
        return dao.getAllAlarm()
    }


}
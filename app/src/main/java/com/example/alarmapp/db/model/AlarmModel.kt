package com.example.alarmapp.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm_table")
data class AlarmModel(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "alarm") val alarm: String,
    val hour: Int,
    val minute: Int,
    var onOff: Boolean
) {

    val timeText: String
        get() {
            val h = "%02d".format(if (hour < 12) hour else hour - 12)
            val m = "%02d".format(minute)

            return "$h:$m"
        }

    val ampmText: String
        get() {
            return if (hour < 12) "AM" else "PM"
        }

    val onOffText: String
        get() {
            return if (onOff) "알람 끄기" else "알람 켜기"
        }

    fun makeDataForDB(): String {
        return "$hour:$minute"
    }

}
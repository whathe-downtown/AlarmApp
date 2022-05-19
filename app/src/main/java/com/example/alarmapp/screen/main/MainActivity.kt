package com.example.alarmapp.screen.main

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.alarmapp.AlarmReceiver
import com.example.alarmapp.R
import com.example.alarmapp.databinding.ActivityMainBinding

import com.example.alarmapp.model.AlarmDisplayModel
import com.example.alarmapp.screen.base.BaseActivity
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainActivity =this
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.currentButtonValue.observe(this,{
//            binding.onOffButton.text = it.toString()
        })

        val navHostFragment= supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.myBottomNav, navController)
//        initOnOffButton()
//        initChangeAlarmTimeButton()
//
//        val model = fetchDataFromSharedPreferences()
//        renderView(model)

    }

//    private fun initOnOffButton() {
//
//        binding.onOffButton.setOnClickListener {
//
//            val model = it.tag as? AlarmDisplayModel ?: return@setOnClickListener
//            val newModel = saveAlarmModel(model.hour, model.minute, model.onOff.not())
//            renderView(newModel)
//
//            if (newModel.onOff) {
//                // 켜진 경우 -> 알람을 등록
//                val calendar = Calendar.getInstance().apply {
//                    set(Calendar.HOUR_OF_DAY, newModel.hour)
//                    set(Calendar.MINUTE, newModel.minute)
//                    // 캘린터에 세팅한 시간이 지금시간보다 이전이라면, 내일 해당 시간이라는 의미이므로 Day를 +1 해줌
//                    if (before(Calendar.getInstance())) {
//                        add(Calendar.DATE, 1)
//                    }
//                }
//                //주어진 시간에 메세지 보내기 위함
//                val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//                val intent = Intent(this, AlarmReceiver::class.java)
//                val pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE,
//                    intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
//
//                alarmManager.setInexactRepeating(
//                    // 시간을 어떻게 셀 것인지 정함 ㅡ,
//                    // RTC_WAKEUP -> 실제 시간 기준으로 wakeup ( 절대시간 )
//                    // ELAPSED_REALTIME_WAKEUP -> 스마트폰이 부팅된 이후부터 시간을 기준으로 wake upㅡ, 좀더 권장됨,, 이유는 확인해봐야할듯
//                    AlarmManager.RTC_WAKEUP,
//                    calendar.timeInMillis,
//                    AlarmManager.INTERVAL_DAY,
//                    pendingIntent
//                )
//
//            } else {
//                cancelAlarm()
//            }
//
//        }
//    }
//
//    private fun initChangeAlarmTimeButton() {
//        binding.changeAlarmTimeButton.setOnClickListener {
//
//            val calendar = Calendar.getInstance()
//            TimePickerDialog(this, { picker, hour, minute ->
//
//                val model = saveAlarmModel(hour, minute, false)
//                renderView(model)
//                cancelAlarm()
//
//            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show()
//
//        }
//
//    }
//
//    private fun saveAlarmModel(
//        hour: Int,
//        minute: Int,
//        onOff: Boolean
//    ): AlarmDisplayModel {
//        val model = AlarmDisplayModel(
//            hour = hour,
//            minute = minute,
//            onOff = onOff
//        )
//
//        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
//
//        with(sharedPreferences.edit()) {
//            putString(ALARM_KEY, model.makeDataForDB())
//            putBoolean(ONOFF_KEY, model.onOff)
//            commit()
//        }
//
//        return model
//    }
//
//    private fun fetchDataFromSharedPreferences(): AlarmDisplayModel {
//        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
//
//        val timeDBValue = sharedPreferences.getString(ALARM_KEY, "9:30") ?: "9:30"
//        val onOffDBValue = sharedPreferences.getBoolean(ONOFF_KEY, false)
//        val alarmData = timeDBValue.split(":")
//
//        val alarmModel = AlarmDisplayModel(
//            hour = alarmData[0].toInt(),
//            minute = alarmData[1].toInt(),
//            onOff = onOffDBValue
//        )
//
//        // 보정 보정 예외처리
//
//        val pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE, Intent(this, AlarmReceiver::class.java),  PendingIntent.FLAG_NO_CREATE or PendingIntent.FLAG_MUTABLE)
//
//        if ((pendingIntent == null) and alarmModel.onOff) {
//            // 알람은 꺼져있는데, 데이터는 켜저있는 경우
//            alarmModel.onOff = false
//
//        } else if ((pendingIntent != null) and alarmModel.onOff.not()){
//            // 알람은 켜져있는데, 데이터는 꺼져있는 경우
//            // 알람을 취소함
//            pendingIntent.cancel()
//        }
//
//        return alarmModel
//
//    }
//
//    private fun renderView(model: AlarmDisplayModel) {
//        binding.ampmTextView.apply {
//            text = model.ampmText
//        }
//
//        binding.timeTextView.apply {
//            text = model.timeText
//        }
//
//        binding.onOffButton.apply {
//            text = model.onOffText
//            tag = model
//        }
//
//    }
//
//    private fun cancelAlarm() {
//        val pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE, Intent(
//            this, AlarmReceiver::class.java),  PendingIntent.FLAG_NO_CREATE or PendingIntent.FLAG_MUTABLE)
//        pendingIntent?.cancel()
//    }
//
//    companion object {
//        private const val SHARED_PREFERENCES_NAME = "time"
//        private const val ALARM_KEY = "alarm"
//        private const val ONOFF_KEY = "onOff"
//        private const val ALARM_REQUEST_CODE = 1000
//
//    }
}
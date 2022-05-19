package com.example.alarmapp.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


enum class AlarmStateType{
    ON, OFF
}

class MainViewModel() : ViewModel(){

    private val _currentAlarmButtonValue = MutableLiveData<Boolean>()

    val currentButtonValue : LiveData<Boolean>
        get() = _currentAlarmButtonValue

    init {
        _currentAlarmButtonValue.value = false
    }

    fun updateButtonValue( type : AlarmStateType){
        when(type){
            AlarmStateType.ON ->
                _currentAlarmButtonValue.value = true
            AlarmStateType.OFF ->
                _currentAlarmButtonValue.value= false

        }
    }
}
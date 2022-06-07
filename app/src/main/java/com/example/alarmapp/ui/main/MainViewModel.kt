package com.example.alarmapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


enum class AlarmStateType{
    ON, OFF
}

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val
) : ViewModel(){

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
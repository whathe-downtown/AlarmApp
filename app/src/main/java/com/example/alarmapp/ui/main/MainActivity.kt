package com.example.alarmapp.ui.main


import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.alarmapp.R
import com.example.alarmapp.databinding.ActivityMainBinding
import com.example.alarmapp.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
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
        }
}
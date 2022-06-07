package com.example.alarmapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T: ViewDataBinding>(@LayoutRes val layoutRes: Int): Fragment(){

    lateinit var binding : T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layoutRes,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this
        super.onViewCreated(view, savedInstanceState)
    }

    protected fun shortShowToast(msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    protected fun longShowToast(msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}
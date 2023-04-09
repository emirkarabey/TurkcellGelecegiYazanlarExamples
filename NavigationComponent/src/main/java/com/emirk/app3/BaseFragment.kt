package com.emirk.app3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logCurrentFragment()
    }

    private fun logCurrentFragment() {
        val fragmentName = this.javaClass.simpleName
        Log.d("CurrentFragment", "Current Fragment: $fragmentName")
    }

}
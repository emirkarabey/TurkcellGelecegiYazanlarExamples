package com.emirk.app3

import android.util.Log
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun showCurrentFragment(currentFragment: Fragment) {
        Log.v("Current Fragment:", currentFragment.javaClass.simpleName)
    }
}
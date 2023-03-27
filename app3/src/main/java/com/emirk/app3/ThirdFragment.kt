package com.emirk.app3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.emirk.app3.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        goToFirstFragment()
        return binding.root
    }

    private fun goToFirstFragment() = binding.btnGoToFirst.setOnClickListener {
        val action = ThirdFragmentDirections.actionThirdFragmentToFirstFragment()
        findNavController().navigate(action)
    }
}
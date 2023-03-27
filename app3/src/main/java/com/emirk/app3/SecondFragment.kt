package com.emirk.app3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.emirk.app3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        goToThirdFragment()
        return binding.root
    }

    private fun goToThirdFragment() = binding.btnGoToThird.setOnClickListener {
        val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
        findNavController().navigate(action)
    }
}
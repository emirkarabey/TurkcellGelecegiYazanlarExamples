package com.emirk.app3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.emirk.app3.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        goToSecondFragment()
        return binding.root
    }

    private fun goToSecondFragment() = binding.btnGoToSecond.setOnClickListener {
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
        findNavController().navigate(action)
    }
}
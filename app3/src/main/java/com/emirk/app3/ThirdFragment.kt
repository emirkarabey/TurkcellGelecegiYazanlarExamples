package com.emirk.app3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.emirk.app3.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoToFirst.setOnClickListener {
            val action = ThirdFragmentDirections.actionThirdFragmentToFirstFragment()
            findNavController().navigate(action)
        }
        showCurrentFragment(currentFragment = this)
    }
}
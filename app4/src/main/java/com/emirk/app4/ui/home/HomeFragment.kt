package com.emirk.app4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.emirk.app4.R
import com.emirk.app4.data.local.entity.Person
import com.emirk.app4.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        observe()
        onClickButton()
        return binding.root
    }

    private fun onClickButton() = binding.btnSave.setOnClickListener {
        if (viewModel.personLiveData.value?.name.isNullOrEmpty()) {
            val person = Person(
                0, binding.tvName.text.toString(),
                binding.tvLastName.text.toString(),
                binding.tvAge.text.toString()
            )
            viewModel.save(person)

            binding.btnSave.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        } else {
            viewModel.delete("Emir")
            binding.btnSave.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun observe() = lifecycleScope.launchWhenCreated {
        viewModel.getData()
        viewModel.personLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.btnSave.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
            } else {
                binding.btnSave.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
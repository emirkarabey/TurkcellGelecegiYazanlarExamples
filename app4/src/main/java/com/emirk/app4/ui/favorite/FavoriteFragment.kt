package com.emirk.app4.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.emirk.app4.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        getData()
        return binding.root
    }

    private fun getData() = lifecycleScope.launchWhenCreated {
        viewModel.getData()
        viewModel.personLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvName.text = it.name
                binding.tvLastName.text = it.lastname
                binding.tvAge.text = it.age
            } else {
                binding.tvName.text = "null"
                binding.tvLastName.text = "null"
                binding.tvAge.text = "null"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
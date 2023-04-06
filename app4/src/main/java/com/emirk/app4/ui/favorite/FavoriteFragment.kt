package com.emirk.app4.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.emirk.app4.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.personLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvName.text = it.name
                binding.tvLastName.text = it.lastname
                binding.tvAge.text = it.age
                binding.tvList.text = it.list!![0]
                binding.tvList2.text = it.list[1]
                binding.tvList3.text = it.list[2]
                binding.tvList4.text = it.list[3]
            } else {
                binding.tvName.text = "null"
                binding.tvLastName.text = "null"
                binding.tvAge.text = "null"
                binding.tvList.text = "null"
                binding.tvList2.text = "null"
                binding.tvList3.text = "null"
                binding.tvList4.text = "null"
            }
        }
        viewModel.getPerson()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
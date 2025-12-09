package com.example.kuchnia_polska.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kuchnia_polska.R
import com.example.kuchnia_polska.databinding.FragmentMenuChoiceBinding

class MenuChoiceFragment : Fragment() {

    private var _binding: FragmentMenuChoiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentMenuChoiceBinding.inflate(inflater, container, false)

        binding.btnReady.setOnClickListener {
            findNavController().navigate(R.id.readyMealFragment)
        }

        binding.btnCustom.setOnClickListener {
            findNavController().navigate(R.id.customMealFragment)
        }

        return binding.root
    }
}

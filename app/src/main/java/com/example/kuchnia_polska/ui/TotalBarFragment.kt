package com.example.kuchnia_polska.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kuchnia_polska.databinding.FragmentTotalBarBinding
import com.example.kuchnia_polska.viewmodel.OrderViewModel

class TotalBarFragment : Fragment() {

    private val vm: OrderViewModel by activityViewModels()
    private var _binding: FragmentTotalBarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentTotalBarBinding.inflate(inflater, container, false)

        vm.aktualne.observe(viewLifecycleOwner) {
            binding.tvCurrent.text = it.cena.toString()
        }

        vm.wszystkie.observe(viewLifecycleOwner) {
            binding.tvAll.text = it.totalAll().toString()
        }

        return binding.root
    }
}

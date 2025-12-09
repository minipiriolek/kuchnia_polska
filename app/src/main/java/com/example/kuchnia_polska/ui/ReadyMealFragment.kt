package com.example.kuchnia_polska.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.kuchnia_polska.R
import com.example.kuchnia_polska.viewmodel.OrderViewModel
import com.google.android.material.snackbar.Snackbar

class ReadyMealFragment : Fragment() {

    private val vm: OrderViewModel by activityViewModels()
    private lateinit var btnAdd1: Button
    private lateinit var btnAdd2: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ready_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAdd1 = view.findViewById(R.id.ready_btn_add1)
        btnAdd2 = view.findViewById(R.id.ready_btn_add2)

        btnAdd1.setOnClickListener {
            vm.ustawImie("Gość")
            vm.ustawZupe("Rosół")
            vm.ustawDanie("Schabowy")
            vm.ustawNapoj("Kompot")
            vm.potwierdzZamowienie()
            Toast.makeText(requireContext(), "Dodano: Rosół + Schabowy + Kompot", Toast.LENGTH_SHORT).show()

            Snackbar.make(view, "Dodano danie", Snackbar.LENGTH_LONG)
                .setAction("Przejdź do Komponuj sam") {
                    findNavController().navigate(R.id.customMealFragment)
                }
                .show()
        }

        btnAdd2.setOnClickListener {
            vm.ustawImie("Gość")
            vm.ustawZupe("Pomidorowa")
            vm.ustawDanie("Pierogi")
            vm.ustawNapoj("Woda")
            vm.potwierdzZamowienie()
            Toast.makeText(requireContext(), "Dodano: Pomidorowa + Pierogi + Woda", Toast.LENGTH_SHORT).show()

            Snackbar.make(view, "Dodano danie", Snackbar.LENGTH_LONG)
                .setAction("Przejdź do Komponuj sam") {
                    findNavController().navigate(R.id.customMealFragment)
                }
                .show()
        }
    }
}

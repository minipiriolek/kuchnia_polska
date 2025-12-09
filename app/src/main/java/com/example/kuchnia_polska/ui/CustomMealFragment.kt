package com.example.kuchnia_polska.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.kuchnia_polska.R
import com.example.kuchnia_polska.viewmodel.OrderViewModel
import com.google.android.material.snackbar.Snackbar

class CustomMealFragment : Fragment() {

    private val vm: OrderViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_custom_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAdd = view.findViewById<Button>(R.id.custom_btn_add)
        val rbRosol = view.findViewById<RadioButton>(R.id.custom_rb_rosol)
        val rbPomidor = view.findViewById<RadioButton>(R.id.custom_rb_pomidorowa)
        val rbSchab = view.findViewById<RadioButton>(R.id.custom_rb_schabowy)
        val rbPierogi = view.findViewById<RadioButton>(R.id.custom_rb_pierogi)
        val rbWoda = view.findViewById<RadioButton>(R.id.custom_rb_woda)
        val rbKompot = view.findViewById<RadioButton>(R.id.custom_rb_kompot)

        btnAdd.setOnClickListener {
            vm.ustawImie("Klient")
            if (rbRosol.isChecked) vm.ustawZupe("Rosół") else if (rbPomidor.isChecked) vm.ustawZupe("Pomidorowa") else vm.ustawZupe(null)
            if (rbSchab.isChecked) vm.ustawDanie("Schabowy") else if (rbPierogi.isChecked) vm.ustawDanie("Pierogi") else vm.ustawDanie(null)
            if (rbWoda.isChecked) vm.ustawNapoj("Woda") else if (rbKompot.isChecked) vm.ustawNapoj("Kompot") else vm.ustawNapoj(null)
            vm.potwierdzZamowienie()
            Toast.makeText(requireContext(), "Dodano zamówienie", Toast.LENGTH_SHORT).show()

            Snackbar.make(view, "Dodano zamówienie", Snackbar.LENGTH_LONG)
                .setAction("Przejdź do Gotowe dania") {
                    findNavController().navigate(R.id.readyMealFragment)
                }
                .show()
        }
    }
}

package com.example.kuchnia_polska.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kuchnia_polska.R
import com.example.kuchnia_polska.viewmodel.OrderViewModel

class SummaryFragment : Fragment(R.layout.fragment_summary) {

    private val viewModel: OrderViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSummary = view.findViewById<TextView>(R.id.tvSummaryList)
        val tvTotal = view.findViewById<TextView>(R.id.tvTotal)

        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        val btnNew = view.findViewById<Button>(R.id.btnNewOrder)
        val btnClear = view.findViewById<Button>(R.id.btnClearAll)

        viewModel.wszystkie.observe(viewLifecycleOwner) { order ->
            if (order.zamowienia.isEmpty()) {
                tvSummary.text = "Brak zamówień"
                tvTotal.text = "Suma: 0 zł"
            } else {
                val sb = StringBuilder()
                order.zamowienia.forEachIndexed { index, p ->
                    sb.append("Osoba ${index + 1}: ${p.osobaNazwa}\n")
                    sb.append("Zupa: ${p.zupa ?: "-"}\n")
                    sb.append("Danie: ${p.danieGl ?: "-"}\n")
                    sb.append("Napój: ${p.napoj ?: "-"}\n")
                    sb.append("Cena: ${p.cena} zł\n\n")
                }
                tvSummary.text = sb.toString()
                tvTotal.text = "Suma: ${order.totalAll()} zł"
            }
        }

        btnSubmit.setOnClickListener {
            Toast.makeText(requireContext(), "Zamówienie złożone ✅", Toast.LENGTH_SHORT).show()
        }

        btnNew.setOnClickListener {
            Toast.makeText(requireContext(), "Nowe zamówienie", Toast.LENGTH_SHORT).show()
        }

        btnClear.setOnClickListener {
            viewModel.wyczyscWszystko()
            Toast.makeText(requireContext(), "Wyczyszczono ✅", Toast.LENGTH_SHORT).show()
        }
    }
}

package com.example.kuchnia_polska.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kuchnia_polska.model.Order
import com.example.kuchnia_polska.model.PersonOrder

class OrderViewModel : ViewModel() {

    private val _aktualne = MutableLiveData<PersonOrder>(PersonOrder())
    val aktualne: LiveData<PersonOrder> = _aktualne

    private val _wszystkie = MutableLiveData<Order>(Order())
    val wszystkie: LiveData<Order> = _wszystkie
    private val ceny = mapOf(
        "Zupa:Rosół" to 8.0,
        "Zupa:Pomidorowa" to 9.0,
        "Danie:Schabowy" to 25.0,
        "Danie:Pierogi" to 18.0,
        "Napoj:Woda" to 5.0,
        "Napoj:Kompot" to 6.0
    )

    fun ustawImie(imie: String) {
        val p = _aktualne.value ?: PersonOrder()
        p.osobaNazwa = imie
        _aktualne.value = p
        przeliczCena()
    }
    fun ustawZupe(zupa: String?) {
        val p = _aktualne.value ?: PersonOrder()
        p.zupa = zupa
        przeliczCena()
        _aktualne.value = p
    }
    fun ustawDanie(danie: String?) {
        val p = _aktualne.value ?: PersonOrder()
        p.danieGl = danie
        przeliczCena()
        _aktualne.value = p
    }
    fun ustawNapoj(napoj: String?) {
        val p = _aktualne.value ?: PersonOrder()
        p.napoj = napoj
        przeliczCena()
        _aktualne.value = p
    }
    private fun przeliczCena() {
        val p = _aktualne.value ?: return
        var s = 0.0
        p.zupa?.let { s += ceny["Zupa:$it"] ?: 0.0 }
        p.danieGl?.let { s += ceny["Danie:$it"] ?: 0.0 }
        p.napoj?.let { s += ceny["Napoj:$it"] ?: 0.0 }
        p.cena = s
    }
    fun potwierdzZamowienie() {
        val p = _aktualne.value ?: return
        val kopia = p.copy()
        val o = _wszystkie.value ?: Order()
        o.add(kopia)
        _wszystkie.value = o
        _aktualne.value = PersonOrder()
    }
    fun sumaBiezacego(): Double {
        return _aktualne.value?.cena ?: 0.0
    }
    fun sumaWszystkich(): Double {
        return _wszystkie.value?.totalAll() ?: 0.0
    }
    fun wyczyscWszystko() {
        _wszystkie.value = Order()
        _aktualne.value = PersonOrder()
    }
}

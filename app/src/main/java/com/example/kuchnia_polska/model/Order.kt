package com.example.kuchnia_polska.model



data class Order (
    val zamowienia: MutableList<PersonOrder> = mutableListOf()
){
fun add(personOrder: PersonOrder) {
    zamowienia.add(personOrder)
}
    fun totalAll(): Double = zamowienia.sumOf { it.cena }
}
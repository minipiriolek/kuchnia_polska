package com.example.polskakuchnia.model

data class PersonOrder(
    var osobaNazwa: String = "",
    var zupa: String? = null,
    var danieGl: String? = null,
    var napoj: String? = null,
    var cena: Double = 0.0
)

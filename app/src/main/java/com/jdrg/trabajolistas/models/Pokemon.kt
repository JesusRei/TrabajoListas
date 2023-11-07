package com.jdrg.trabajolistas.models

import android.graphics.Bitmap

class Pokemon (
    name: String,
    number: String,
    type: String,
    nature: String,
    sex: String,
    ability: String,
    imagen: Bitmap?
)
{
    var name: String
    var number: String
    var type: String
    var nature: String
    var sex: String
    var ability: String
    var imagen: Bitmap?

    init {
        this.name = name
        this.number = number
        this.type = type
        this.nature = nature
        this.sex =sex
        this.ability = ability
        this.imagen = imagen
    }
}
package com.jdrg.trabajolistas.models

import android.graphics.Bitmap

class Persona(
    nombreCompleto: String,
    numeroTelefono: String,
    correoElectronico: String,
    direccion: String,
    imagen: Bitmap?
) {
    var nombreCompleto: String
    var numeroTelefono: String
    var correoElectronico: String
    var direccion: String
    var imagen: Bitmap?

    init {
        this.nombreCompleto = nombreCompleto
        this.numeroTelefono = numeroTelefono
        this.correoElectronico = correoElectronico
        this.direccion = direccion
        this.imagen = imagen
    }
}
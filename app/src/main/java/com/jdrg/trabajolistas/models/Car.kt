package com.jdrg.trabajolistas.models

import android.graphics.Bitmap

class Car(
    make: String,
    model: String,
    vin: String,
    mileage: String,
    year: String,
    licensePlate: String,
    imagen: Bitmap?
) {
    var make: String
    var model: String
    var vin: String
    var mileage: String
    var year: String
    var licensePlate: String
    var imagen: Bitmap?

    init {
        this.make = make
        this.model = model
        this.vin = vin
        this.mileage = mileage
        this.year = year
        this.licensePlate = licensePlate
        this.imagen = imagen
    }
}
package com.jdrg.trabajolistas

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jdrg.trabajolistas.databinding.ActivityMainFormCarsBinding
import com.jdrg.trabajolistas.models.Car
import com.jdrg.trabajolistas.models.Parameters


class MainActivityFormCars : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainFormCarsBinding
    private val cars = ArrayList<Car>() //
    private var imagen: Bitmap? = null

    companion object {
        private const val SELECT_IMAGE_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFormCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSelectImageCar.setOnClickListener(this)
        binding.buttonCar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonSelectImageCar -> {
                //Manejo Imagen
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
            }

            R.id.buttonCar -> {
                val make = binding.brandCar.text.toString()
                val model = binding.modelCar.text.toString()
                val vin = binding.vinCar.text.toString()
                val mileage = binding.mileageCar.text.toString()
                val year = binding.yearCar.text.toString()
                val licensePlate = binding.plateCar.text.toString()

                if (make.isEmpty() || model.isEmpty() || vin.isEmpty() || mileage.isEmpty() || year.isEmpty() || licensePlate.isEmpty()) {
                    Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT)
                        .show()
                    return
                }

                val car = Car(make, model, vin, mileage, year, licensePlate, imagen)
                this.cars.add(car)

                Parameters.setCarsList(car)


                if (!cars.isEmpty() && cars.last().imagen != null) {
                    Toast.makeText(
                        this,
                        "El carro se matriculo correctamente",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this, "Fallo en el registro", Toast.LENGTH_SHORT).show()
                }

                // Limpiar los campos del formulario después de guardar
                binding.brandCar.setText("")
                binding.modelCar.setText("")
                binding.vinCar.setText("")
                binding.mileageCar.setText("")
                binding.yearCar.setText("")
                binding.plateCar.setText("")
                finish()

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            try {
                val inputStream = contentResolver.openInputStream(selectedImageUri!!)
                imagen = BitmapFactory.decodeStream(inputStream)

                // Mostrarla en mi ImageViewPokemon
                binding.imageFieldCar.setImageBitmap(imagen)
            } catch (e: Exception) {
                Toast.makeText(this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
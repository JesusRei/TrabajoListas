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
import com.jdrg.trabajolistas.databinding.ActivityMainFormPeopleBinding
import com.jdrg.trabajolistas.models.Parameters
import com.jdrg.trabajolistas.models.Persona


class MainActivityFormPeople : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainFormPeopleBinding
    private val personas = ArrayList<Persona>() //
    private var imagen: Bitmap? = null

    companion object {
        private const val SELECT_IMAGE_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFormPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSelectImage.setOnClickListener(this)
        binding.buttonPerson.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonSelectImage -> {
                //Manejo Imagen
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
            }

            R.id.buttonPerson -> {
                val nombreCompleto = binding.fullName.text.toString()
                val numeroTelefono = binding.phoneNumber.text.toString()
                val correoElectronico = binding.emailAddress.text.toString()
                val direccion = binding.addressField.text.toString()

                if (nombreCompleto.isEmpty() || numeroTelefono.isEmpty() || correoElectronico.isEmpty() || direccion.isEmpty()) {
                    Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT)
                        .show()
                    return
                }

                val persona = Persona(nombreCompleto, numeroTelefono, correoElectronico, direccion, imagen)
                this.personas.add(persona)

                Parameters.setPersonasList(persona)


                if (!personas.isEmpty() && personas.last().imagen != null) {
                    Toast.makeText(this, "Persona guardada con éxito", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "La lista sigue estando vacía", Toast.LENGTH_SHORT).show()
                }

                // Limpiar los campos del formulario después de guardar
                binding.fullName.setText("")
                binding.phoneNumber.setText("")
                binding.emailAddress.setText("")
                binding.addressField.setText("")
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

                // Mostrarla en mi ImageView
                binding.imageField.setImageBitmap(imagen)
            } catch (e: Exception) {
                Toast.makeText(this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
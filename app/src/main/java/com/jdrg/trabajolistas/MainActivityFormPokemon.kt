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
import com.jdrg.trabajolistas.databinding.ActivityMainFormPokemonBinding
import com.jdrg.trabajolistas.models.Parameters
import com.jdrg.trabajolistas.models.Pokemon

class MainActivityFormPokemon : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainFormPokemonBinding
    private val pokemons = ArrayList<Pokemon>() //
    private var imagen: Bitmap? = null

    companion object {
        private const val SELECT_IMAGE_REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFormPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSelectImagePokemon.setOnClickListener(this)
        binding.buttonPokemon.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonSelectImagePokemon -> {
                //Manejo Imagen
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
            }

            R.id.buttonPokemon -> {
                val name = binding.namePokemon.text.toString()
                val number = binding.numberPokemon.text.toString()
                val type = binding.typePokemon.text.toString()
                val nature = binding.naturePokemon.text.toString()
                val sex = binding.sexPokemon.text.toString()
                val ability = binding.abilityPokemon.text.toString()

                if (name.isEmpty() || number.isEmpty() || type.isEmpty() || nature.isEmpty() || sex.isEmpty() || ability.isEmpty()) {
                    Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT)
                        .show()
                    return
                }

                val pokemon = Pokemon(name, number, type, nature, sex, ability, imagen)
                this.pokemons.add(pokemon)

                Parameters.setPokemonsList(pokemon)


                if (!pokemons.isEmpty() && pokemons.last().imagen != null) {
                    Toast.makeText(
                        this,
                        "El Pokémon ha sido registrado exitosamente en la Pokédex",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this, "Fallo en el registro", Toast.LENGTH_SHORT).show()
                }

                // Limpiar los campos del formulario después de guardar
                binding.namePokemon.setText("")
                binding.numberPokemon.setText("")
                binding.typePokemon.setText("")
                binding.naturePokemon.setText("")
                binding.sexPokemon.setText("")
                binding.abilityPokemon.setText("")
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
                binding.imageFieldPokemon.setImageBitmap(imagen)
            } catch (e: Exception) {
                Toast.makeText(this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
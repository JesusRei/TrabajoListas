package com.jdrg.trabajolistas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jdrg.trabajolistas.adapters.PokemonAdapter
import com.jdrg.trabajolistas.databinding.ActivityMainListPokemonBinding
import com.jdrg.trabajolistas.models.Parameters

class MainActivityListPokemon : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainListPokemonBinding
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainListPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageAnadirPokemon.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        adapter = PokemonAdapter(this, Parameters.getPokemonsList())
        binding.listViewPokemon.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    override fun onClick(p0: View?) {
        if (p0?.id == R.id.imageAnadirPokemon) {
            startActivity(Intent(this@MainActivityListPokemon, MainActivityFormPokemon::class.java))
        }
    }
}
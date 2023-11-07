package com.jdrg.trabajolistas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jdrg.trabajolistas.adapters.PersonaAdapter
import com.jdrg.trabajolistas.databinding.ActivityMainListPeopleBinding
import com.jdrg.trabajolistas.models.Parameters


class MainActivityListPeople : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainListPeopleBinding

    private lateinit var adapter: PersonaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainListPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageAnadirPersona.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()

        adapter = PersonaAdapter(this, Parameters.getPersonasList())
        binding.listViewPers.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.imageAnadirPersona) {
            startActivity(Intent(this@MainActivityListPeople, MainActivityFormPeople::class.java))
        }
    }
}

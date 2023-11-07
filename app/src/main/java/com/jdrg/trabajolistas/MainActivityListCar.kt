package com.jdrg.trabajolistas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jdrg.trabajolistas.adapters.CarAdapter
import com.jdrg.trabajolistas.databinding.ActivityMainListCarBinding
import com.jdrg.trabajolistas.models.Parameters

class MainActivityListCar : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainListCarBinding
    private lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainListCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageAnadirCar.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        adapter = CarAdapter(this, Parameters.getCarsList())
        binding.listViewCar.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    override fun onClick(p0: View?) {
        if (p0?.id == R.id.imageAnadirCar) {
            startActivity(Intent(this@MainActivityListCar, MainActivityFormCars::class.java))
        }
    }
}
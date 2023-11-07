package com.jdrg.trabajolistas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jdrg.trabajolistas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imagePeople.setOnClickListener(this)
        binding.imageCar.setOnClickListener(this)
        binding.imagePokemon.setOnClickListener(this)



    }


    override fun onClick(p0: View?) {
        if (p0?.id == R.id.imagePeople){
            startActivity(Intent(this@MainActivity, MainActivityListPeople::class.java))

        }
        else if (p0?.id == R.id.imageCar){
            startActivity(Intent(this@MainActivity, MainActivityListCar::class.java))
        }else if (p0?.id == R.id.imagePokemon){
            startActivity(Intent(this@MainActivity, MainActivityListPokemon::class.java))
        }

    }
}
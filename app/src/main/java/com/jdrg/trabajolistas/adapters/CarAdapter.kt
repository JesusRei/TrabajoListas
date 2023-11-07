package com.jdrg.trabajolistas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jdrg.trabajolistas.databinding.ItemCarBinding
import com.jdrg.trabajolistas.models.Car


class CarAdapter(private val c: Context, private val datos: ArrayList<Car>) : BaseAdapter() {

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(p0: Int): Any {
        return datos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: CarViewHolder
        val listItemView: View

        if (convertView == null) {
            val itemBinding = ItemCarBinding.inflate(LayoutInflater.from(c), parent, false)
            holder = CarViewHolder(itemBinding)
            listItemView = holder.view
            listItemView.tag = holder
        } else {
            listItemView = convertView
            holder = listItemView.tag as CarViewHolder
        }

        val car = datos[position]

        holder.binding.textViewBrandCar.text = car.make
        holder.binding.textViewModelCar.text = car.model
        holder.binding.textViewVinCar.text = car.vin
        holder.binding.textViewMileageCar.text = car.mileage
        holder.binding.textViewYearCar.text = car.year
        holder.binding.textViewPlateCar.text = car.licensePlate
        holder.binding.imageViewCar.setImageBitmap(car.imagen)

        return listItemView
    }

    class CarViewHolder(itemBinding: ItemCarBinding) {
        var view: View = itemBinding.root
        var binding: ItemCarBinding = itemBinding
    }
}

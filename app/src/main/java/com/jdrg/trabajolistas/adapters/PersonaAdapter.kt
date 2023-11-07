package com.jdrg.trabajolistas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jdrg.trabajolistas.databinding.ItemPersonaBinding
import com.jdrg.trabajolistas.models.Persona

class PersonaAdapter(private val c: Context, private val datos: ArrayList<Persona>) :
    BaseAdapter() {

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
        val holder: PersonaViewHolder
        val listItemView: View

        if (convertView == null) {
            val itemBinding =
                ItemPersonaBinding.inflate(LayoutInflater.from(c), parent, false)
            holder = PersonaViewHolder(itemBinding)
            listItemView = holder.view
            listItemView.tag = holder
        } else {
            listItemView = convertView
            holder = listItemView.tag as PersonaViewHolder
        }

        val persona = datos[position]

        holder.binding.textViewNombre.text = persona.nombreCompleto
        holder.binding.textViewCelular.text = persona.numeroTelefono
        holder.binding.textViewCorreo.text = persona.correoElectronico
        holder.binding.textViewDireccion.text = persona.direccion
        holder.binding.imageView.setImageBitmap(persona.imagen)


        return listItemView
    }

    class PersonaViewHolder(itemBinding: ItemPersonaBinding) {
        var view: View = itemBinding.root
        var binding: ItemPersonaBinding = itemBinding
    }
}
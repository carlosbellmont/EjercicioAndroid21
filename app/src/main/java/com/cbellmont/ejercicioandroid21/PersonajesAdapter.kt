package com.cbellmont.ejercicioandroid21

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class PersonajesAdapter(var inter : MainActivityAdapterInterface, var listaPersonajes : List<Personaje>) : RecyclerView.Adapter<PersonajesAdapter.PersonajesViewHolder>()  {

    class PersonajesViewHolder(val root: View, val  imageView: ImageView, val textViewNombre: TextView, val textViewRaza : TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val ivFoto = view.findViewById<ImageView>(R.id.iwFoto)
        val tvRaza = view.findViewById<TextView>(R.id.tvRaza)
        val tvNombre = view.findViewById<TextView>(R.id.tvNombre)

        return PersonajesViewHolder(view, ivFoto, tvNombre, tvRaza)
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        holder.imageView.setImageResource(listaPersonajes[position].image)
        holder.textViewNombre.text = listaPersonajes[position].nombre
        holder.textViewRaza.text = listaPersonajes[position].raza
        holder.root.setBackgroundColor(ContextCompat.getColor(holder.root.context, if (listaPersonajes[position].esBueno) R.color.colorBgBueno else R.color.colorBgMalo))

        holder.imageView.setOnClickListener{ inter.onPersonajeCliked(listaPersonajes[position]) }
    }
}


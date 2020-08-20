package com.cbellmont.ejercicioandroid19

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity() {

    companion object {
        const val CLAVE_1 = "myClave1"

        fun getIntent(context: Context, personaje: Personaje) : Intent {
            return Intent(context, SecondActivity::class.java).apply { putExtra(CLAVE_1, personaje) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val personaje = intent.getSerializableExtra(CLAVE_1)
        personaje as Personaje

        iwFoto.setImageResource(personaje.image)
        tvNombre.text = personaje.nombre
        tvRaza.text = personaje.raza

    }

}
package com.cbellmont.ejercicioandroid21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_layout.*

class FragmentPersonaje : Fragment () {

    lateinit var personaje : Personaje
    lateinit var interfazConMainActivity : MainActivityFragmentInterface

    companion object {
        const val CLAVE_1 = "clave1"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personaje = arguments?.getSerializable(CLAVE_1) as Personaje
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iwFoto.setImageResource(personaje.image)
        tvNombre.text = personaje.nombre
        tvRaza.text = personaje.raza
        iwFoto.setOnClickListener {
            interfazConMainActivity.onImageClicked()
            fragmentManager?.beginTransaction()?.remove(this)?.commitAllowingStateLoss()

        }
    }

    fun setInterfaz(mainactivityFragment : MainActivityFragmentInterface) {
        this.interfazConMainActivity = mainactivityFragment
    }

}
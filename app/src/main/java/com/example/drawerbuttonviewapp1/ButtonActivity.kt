package com.example.drawerbuttonviewapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ButtonActivity : AppCompatActivity() {
    private lateinit var bnvMenu:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        var inicioFragment = inicioFragment()
        var mensajeFragment = mensajeFragment()
        var perfilFragment = PerfilFragment()

        setFragmentActual(inicioFragment)

        bnvMenu = findViewById(R.id.bnv_Menu)
        bnvMenu.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.myInicio->{
                    setFragmentActual(inicioFragment)
                }
                R.id.myMensaje->{
                    setFragmentActual(mensajeFragment)
                }
                R.id.myPerfil->{
                    setFragmentActual(perfilFragment)
                }
            }
        }

    }

    private fun setFragmentActual(fragment: Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.fl_Vista, fragment)
        commit()

    }
}
package com.example.nueva.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nueva.Greeting
import android.widget.TextView
import com.example.nueva.RepositorioDelClima
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val repositorio = RepositorioDelClima()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        val tv2: TextView = findViewById(R.id.text_view2)
        val tv3: TextView = findViewById(R.id.text_view3)

        tv.text = "Cargando...."

        MainScope().launch{
            kotlin.runCatching {
                repositorio.obtenerClima()
            }.onSuccess { respuesta ->
                tv.text = respuesta.estado
                tv2.text = respuesta.hora
                tv3.text = respuesta.temperatura

            }.onFailure {error ->
                tv.text = error.toString()
            }

        }

    }
}

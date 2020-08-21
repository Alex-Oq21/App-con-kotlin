package com.example.myapplicationclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    var TvCiudad:TextView?=null
    var TvGrados:TextView?=null
    var TvEstatus:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TvCiudad = findViewById(R.id.TvCiudad)
        TvGrados = findViewById(R.id.TvGrados)
        TvEstatus = findViewById(R.id.TvEstatus)
        val ciudad = intent.getStringExtra("com.example.myapplicationclima.CIUDAD")
        if (Network.hayRed(this)){
            solicitudesHTTP("api.openweathermap.org/data/2.5/weather?id=3674962&appid=a34b67bfd9f17ed8bad032a7d0ec7fdd")
            //a34b67bfd9f17ed8bad032a7d0ec7fdd
            //ID Medellín 3674962

        }else{

        }
        val ciudadMede = Ciudad("Medellín", 28,"soleado")
        val ciudadCali = Ciudad("Cali", 32, "nublado")
        if (ciudad == "ciudad-medellin"){
            //Mostar clima ciudad  Medellín
            TvCiudad?.text = ciudadMede.nombre
            TvGrados?.text = ciudadMede.grados.toString() + "°"
            TvEstatus?.text = ciudadMede.estatus

        }else if (ciudad == "ciudad-cali"){
            //Mostar información ciudad Cali
            TvCiudad?.text = ciudadCali.nombre
            TvGrados?.text = ciudadCali.grados.toString() + "°"
            TvEstatus?.text = ciudadCali.estatus

        }else{
            Toast.makeText(this, "No se encuentra la información.", Toast.LENGTH_SHORT).show()

        }

    }
    private fun solicitudesHTTP(url: String) {
        val queve = Volley.newRequestQueue(this)
        val solicitud =
            StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
                try {
                    Log.d("SolicitudHTTPVolley", response)
                } catch (e: Exception) {

                }
            }, Response.ErrorListener { })
        queve.add(solicitud)
    }
}
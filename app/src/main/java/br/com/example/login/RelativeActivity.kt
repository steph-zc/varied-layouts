package br.com.example.login

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RelativeActivity : AppCompatActivity(){

    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)
        linkComponents()
        configButton()
    }

    private fun linkComponents(){
        btnBack = findViewById(R.id.btnBack)
    }

    private fun configButton(){
        btnBack.setOnClickListener { finish() }
    }

}

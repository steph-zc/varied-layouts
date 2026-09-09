package br.com.example.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(){

    private lateinit var btnConstraint: Button
    private lateinit var btnRelative: Button
    private lateinit var btnTable: Button
    private lateinit var btnLinear: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("HomeActivity","onCreate: tela criada")
        linkComponents()
        configButtons()
    }

    private fun linkComponents(){
        btnConstraint = findViewById(R.id.btnConstraint)
        btnRelative = findViewById(R.id.btnRelative)
        btnTable = findViewById(R.id.btnTable)
        btnLinear = findViewById(R.id.btnLinear)
    }

    private fun configButtons(){
        btnConstraint.setOnClickListener { openScreen(ConstraintActivity::class.java) }
        btnRelative.setOnClickListener { openScreen(RelativeActivity::class.java) }
        btnTable.setOnClickListener { openScreen(TableActivity::class.java) }
        btnLinear.setOnClickListener { openScreen(LinearActivity::class.java) }
    }

    private fun openScreen(screen: Class<out Activity>){
        val intent = Intent(this, screen)
        startActivity(intent)
    }

}

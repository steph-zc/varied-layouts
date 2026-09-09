package br.com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    private lateinit var editUser: EditText
    private lateinit var editPassword: EditText

    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCreate: tela criada")
        linkComponents()
        configButton()
    }

    override fun onStart(){
        super.onStart()
        Log.d("MainActivity","onStart: tela ficou visível")
    }

    override fun onRestart(){
        super.onRestart()
        Log.d("MainActivity","onRestart: tela voltou depois de parada")
    }

    override fun onResume(){
        super.onResume()
        Log.d("MainActivity","onResume: tela pronta para o usuário")
    }

    override fun onPause(){
        super.onPause()
        Log.d("MainActivity","onPause: tela perdeu o foco")
    }

    override fun onStop(){
        super.onStop()
        Log.d("MainActivity","onStop: tela não está mais visível")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("MainActivity","onDestroy: tela destruída")
    }

    private fun linkComponents(){
        editUser = findViewById(R.id.editUser)
        editPassword = findViewById(R.id.editPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun configButton(){
        btnLogin.setOnClickListener {
            Log.d("MainActivity","Clicaram no botao de entrar!")
            doLogin()
        }
    }

    private fun doLogin(){
        // Atividade de layouts: o login nao valida usuario nem senha,
        // qualquer conteudo (inclusive vazio) libera a HomeActivity.
        Toast.makeText(
            this,
            "Login realizado com sucesso",
            Toast.LENGTH_SHORT).show()
        openHome()
    }

    private fun openHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}

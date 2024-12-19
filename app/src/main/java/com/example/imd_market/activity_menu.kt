package com.example.imd_market

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnAlterar = findViewById<Button>(R.id.btnAlterar)
        val btnExcluir = findViewById<Button>(R.id.btnExcluir)
        val btnListar = findViewById<Button>(R.id.btnListar)


        btnCadastrar.setOnClickListener {
            val intent = Intent(this, ActivityCadastro::class.java)
            startActivity(intent)
        }


        btnAlterar.setOnClickListener {
            val intent = Intent(this, ActivityAlteracao::class.java)
            startActivity(intent)
        }


        btnExcluir.setOnClickListener {
            val intent = Intent(this, ActivityExcluir::class.java)
            startActivity(intent)
        }


        btnListar.setOnClickListener {
            val intent = Intent(this, ActivityListagem::class.java)
            startActivity(intent)
        }
    }
}

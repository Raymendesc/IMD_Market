package com.example.imd_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.content.Intent
import android.widget.Button

class ActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Botões do layout
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnExcluir = findViewById<Button>(R.id.btnExcluir)
        val btnListagem = findViewById<Button>(R.id.btnListar)
        val btnAlteracao = findViewById<Button>(R.id.btnAlterar)

        // Manipuladores de clique
        btnCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        btnExcluir.setOnClickListener {
            val intent = Intent(this, ActivityExcluir::class.java)
            startActivity(intent)
        }

        btnListagem.setOnClickListener {
            val intent = Intent(this, ActivityListagem::class.java)
            startActivity(intent)
        }

        btnAlteracao.setOnClickListener {
            val intent = Intent(this, Activity_Alteracao::class.java)
            startActivity(intent)
        }
    }
}



package com.example.imd_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ActivityListagem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        val listViewItens = findViewById<ListView>(R.id.listViewItens)

        // Lista de produtos (só para exibir)
        val produtos = listOf(
            "Produto 1 - Código: 001 - Estoque: 10",
            "Produto 2 - Código: 002 - Estoque: 15",
            "Produto 3 - Código: 003 - Estoque: 20"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, produtos)

        listViewItens.adapter = adapter

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
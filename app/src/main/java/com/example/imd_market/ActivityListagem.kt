package com.example.imd_market

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ActivityListagem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        val listViewItens = findViewById<ListView>(R.id.listViewItens)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)


        val produtos = ProdutoRepository.produtos.map { produto ->
            "Código: ${produto.codigo}\nNome: ${produto.nome}\nDescrição: ${produto.descricao}\nEstoque: ${produto.estoque}"
        }


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, produtos)
        listViewItens.adapter = adapter


        btnVoltar.setOnClickListener {
            finish()
        }
    }
}

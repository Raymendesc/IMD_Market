package com.example.imd_market

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {
            val produtosString = openFileInput("produtos").bufferedReader().readText()
            val produtos = produtosString.split("\n").map { linha ->
                val (codigo, nome, descricao, estoque) = linha.split("|")
                ProdutoRepository.Produto(codigo, nome, descricao, estoque.toInt())
            }
            ProdutoRepository.produtos.addAll(produtos)
            Toast.makeText(this, "Produtos carregados do arquivo!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Nenhum produto encontrado.", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroy() {
        super.onDestroy()


        val produtosString = ProdutoRepository.produtos.joinToString("\n") { produto ->
            "${produto.codigo}|${produto.nome}|${produto.descricao}|${produto.estoque}"
        }


        openFileOutput("produtos", MODE_PRIVATE).use {
            it.write(produtosString.toByteArray())
        }

        Toast.makeText(this, "Produtos salvos no arquivo!", Toast.LENGTH_SHORT).show()
    }
}

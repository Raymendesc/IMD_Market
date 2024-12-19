package com.example.imd_market

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityExcluir : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluir)

        val etCodigoProdutoExcluir = findViewById<EditText>(R.id.etCodigoProdutoExcluir)
        val btnDeletar = findViewById<Button>(R.id.btnDeletar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)


        btnDeletar.setOnClickListener {
            val codigoProduto = etCodigoProdutoExcluir.text.toString()

            if (codigoProduto.isEmpty()) {
                Toast.makeText(this, "Por favor, insira o código do produto para excluir.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val sucesso = ProdutoRepository.excluirProduto(codigoProduto)

            if (sucesso) {
                Toast.makeText(this, "Produto com código $codigoProduto excluído com sucesso!", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "Produto não encontrado.", Toast.LENGTH_SHORT).show()
            }
        }


        btnLimpar.setOnClickListener {
            etCodigoProdutoExcluir.text.clear()
            Toast.makeText(this, "Campo limpo com sucesso.", Toast.LENGTH_SHORT).show()
        }
    }
}

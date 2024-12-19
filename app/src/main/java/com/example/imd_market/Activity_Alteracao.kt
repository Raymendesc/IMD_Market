package com.example.imd_market

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityAlteracao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alteracao)


        val etCodigoProduto = findViewById<EditText>(R.id.etCodigoProduto)
        val etNomeProduto = findViewById<EditText>(R.id.etNomeProduto)
        val etDescricaoProduto = findViewById<EditText>(R.id.etDescricaoProduto)
        val etEstoque = findViewById<EditText>(R.id.etEstoque)
        val btnAlterar = findViewById<Button>(R.id.btnAlterar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnAlterar.setOnClickListener {
            val codigoProduto = etCodigoProduto.text.toString()
            val nomeProduto = etNomeProduto.text.toString()
            val descricaoProduto = etDescricaoProduto.text.toString()
            val estoqueTexto = etEstoque.text.toString()


            if (codigoProduto.isEmpty()) {
                Toast.makeText(this, "Por favor, insira o código do produto.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            if (nomeProduto.isEmpty() && descricaoProduto.isEmpty() && estoqueTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha ao menos um dos campos para alterar.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val estoque = if (estoqueTexto.isNotEmpty()) {
                try {
                    estoqueTexto.toInt()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Estoque deve ser um número válido.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            } else null


            val sucesso = ProdutoRepository.alterarProduto(
                codigo = codigoProduto,
                novoNome = nomeProduto.ifEmpty { null },
                novaDescricao = descricaoProduto.ifEmpty { null },
                novoEstoque = estoque
            )

            if (sucesso) {
                Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Produto não encontrado.", Toast.LENGTH_SHORT).show()
            }
        }


        btnLimpar.setOnClickListener {
            etCodigoProduto.text.clear()
            etNomeProduto.text.clear()
            etDescricaoProduto.text.clear()
            etEstoque.text.clear()
            Toast.makeText(this, "Campos limpos com sucesso.", Toast.LENGTH_SHORT).show()
        }
    }
}

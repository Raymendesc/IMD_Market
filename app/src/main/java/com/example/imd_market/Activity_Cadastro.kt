package com.example.imd_market

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityCadastro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        val etCodigo = findViewById<EditText>(R.id.etCodigoProduto)
        val etNome = findViewById<EditText>(R.id.etNomeProduto)
        val etDescricao = findViewById<EditText>(R.id.etDescricaoProduto)
        val etEstoque = findViewById<EditText>(R.id.etEstoque)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)


        btnSalvar.setOnClickListener {
            val codigo = etCodigo.text.toString()
            val nome = etNome.text.toString()
            val descricao = etDescricao.text.toString()
            val estoqueText = etEstoque.text.toString()


            if (codigo.isEmpty() || nome.isEmpty() || descricao.isEmpty() || estoqueText.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {

                val estoque = try {
                    estoqueText.toInt()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Estoque deve ser um número válido.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                ProdutoRepository.produtos.add(
                    ProdutoRepository.Produto(
                        codigo = codigo,
                        nome = nome,
                        descricao = descricao,
                        estoque = estoque
                    )
                )


                Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()


                finish()
            }
        }


        btnLimpar.setOnClickListener {
            etCodigo.text.clear()
            etNome.text.clear()
            etDescricao.text.clear()
            etEstoque.text.clear()
            Toast.makeText(this, "Campos limpos com sucesso.", Toast.LENGTH_SHORT).show()
        }
    }
}

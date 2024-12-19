package com.example.imd_market

object ProdutoRepository {

    val produtos = mutableSetOf<Produto>()


    data class Produto(
        val codigo: String,
        var nome: String,
        var descricao: String,
        var estoque: Int
    )


    fun adicionarProduto(produto: Produto): Boolean {

        if (produtos.any { it.codigo == produto.codigo }) {
            return false
        }
        produtos.add(produto)
        return true
    }


    fun alterarProduto(codigo: String, novoNome: String?, novaDescricao: String?, novoEstoque: Int?): Boolean {

        val produto = produtos.find { it.codigo == codigo } ?: return false


        novoNome?.let { produto.nome = it }
        novaDescricao?.let { produto.descricao = it }
        novoEstoque?.let { produto.estoque = it }

        return true
    }


    fun excluirProduto(codigo: String): Boolean {

        return produtos.removeIf { it.codigo == codigo }
    }


    fun listarProdutos(): List<Produto> {
        return produtos.toList()
    }
}

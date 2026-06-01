package com.fabricio.gestao_vendas.controller;

import com.fabricio.gestao_vendas.model.Produto;
import com.fabricio.gestao_vendas.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // 1. ENDPOINT PARA CADASTRAR UM PRODUTO (POST)
    @PostMapping
    public Produto criarProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // 2. ENDPOINT PARA LISTAR TODOS OS PRODUTOS (GET)
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // 3. ENDPOINT PARA ATUALIZAR UM PRODUTO POR ID (PUT)
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
    }

    // 4. ENDPOINT PARA DELETAR UM PRODUTO POR ID (DELETE)
    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return "Produto com ID " + id + " deletado com sucesso!";
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }
}
package com.fabricio.gestao_vendas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity // Isso avisa ao banco de dados que essa classe vai virar uma tabela!
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cria o ID automático (1, 2, 3...)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório e não pode ficar em branco.")
    private String nome;

    @NotNull(message = "O preço é obrigatório.")
    @PositiveOrZero(message = "O preço deve ser igual ou maior que zero.")
    private Double preco;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    @Min(value = 0, message = "O estoque não pode ser negativo.")
    private Integer quantidadeEstoque;

    // Construtor padrão obrigatório para o banco de dados
    public Produto() {
    }

    // Construtor completo
    public Produto(Long id, String nome, Double preco, Integer quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e Setters (para podermos acessar e modificar os dados de forma segura)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
package com.fabricio.gestao_vendas.repository;

import com.fabricio.gestao_vendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Avisa ao Spring que essa interface gerencia o acesso ao banco de dados
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Pronto! Herdando o JpaRepository, nós ganhamos de graça os métodos:
    // .save(), .findAll(), .findById(), .deleteById(), entre outros.
}
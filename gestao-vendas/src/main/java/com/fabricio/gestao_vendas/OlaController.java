package com.fabricio.gestao_vendas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {

    @GetMapping("/ola")
    public String dizerOla() {
        return "Bora pra mais aprendizado! API Spring Boot rodando com sucesso.";
    }
}
# 🚀 API de Gestão de Vendas e Produtos

Esta é uma API REST desenvolvida em **Java** com o framework **Spring Boot** para gerenciamento e controle de estoque de produtos (focada no segmento de produtos personalizados). O projeto conta com um CRUD completo e validações robustas de entrada de dados.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17** (ou superior)
* **Spring Boot 3.x**
  * Spring Web (Criação dos Endpoints REST)
  * Spring Data JPA (Persistência e comunicação com o Banco)
  * Validation (Regras de segurança e validação de dados)
* **H2 Database** (Banco de dados em memória para testes rápidos)
* **Maven** (Gerenciador de dependências)
* **Postman** (Testes de requisições)

---

## 🔒 Validações Implementadas

Para garantir a integridade dos dados no banco, o modelo de `Produto` foi blindado com as seguintes regras:
* **Nome:** Obrigatório e não pode conter apenas espaços em branco (`@NotBlank`).
* **Preço:** Obrigatório e não aceita valores negativos (`@PositiveOrZero`).
* **Estoque:** Obrigatório e não aceita quantidade menor que zero (`@Min(0)`).

---

## 🛣️ Endpoints da API

| Método | Endpoint | Descrição | Status Esperado |
| :--- | :--- | :--- | :--- |
| **POST** | `/produtos` | Cadastra um novo produto | `201 Created` ou `200 OK` |
| **GET** | `/produtos` | Lista todos os produtos cadastrados | `200 OK` |
| **PUT** | `/produtos/{id}` | Atualiza os dados de um produto existente | `200 OK` |
| **DELETE** | `/produtos/{id}` | Remove um produto do estoque | `200 OK` |

Se dados inválidos forem enviados no `POST` ou `PUT`, a API automaticamente retornará um status **`400 Bad Request`**.

---

## 🚀 Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/fabriciobmachado/gestao-vendas.git](https://github.com/fabriciobmachado/gestao-vendas.git)

2. Abra o projeto na sua IDE de preferência (recomendado IntelliJ IDEA).

3.Aguarde o Maven baixar as dependências configuradas no pom.xml.

4.Execute a classe principal GestaoVendasApplication.java.

5.A API estará disponível no endereço: http://localhost:8080/produtos.

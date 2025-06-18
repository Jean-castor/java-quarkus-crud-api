# Java Quarkus CRUD API

Este projeto é uma API CRUD desenvolvida em Java utilizando o framework Quarkus. O objetivo principal é fornecer operações de criação, leitura, atualização e exclusão (CRUD) integradas a um banco de dados, permitindo a fácil manipulação de registros através de endpoints RESTful.

## Funcionalidades

- **Operações CRUD**: Permite inserir, buscar, atualizar e remover registros no banco de dados.
- **Arquitetura moderna**: Utiliza o Quarkus, proporcionando alta performance e baixo consumo de memória.
- **Testes Automatizados**: Inclui classes de testes para garantir a qualidade e funcionamento correto das funcionalidades implementadas.

## Tecnologias Utilizadas

- **Java**
- **Quarkus** 
- **JPA/Hibernate** (para persistência de dados)
- **Banco de Dados Relacional** (ex: PostgreSQL, H2, etc.)
- **JUnit** (para testes automatizados)

## Como executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Jean-castor/java-quarkus-crud-api.git
   cd java-quarkus-crud-api
   ```

2. **Execute o projeto em modo desenvolvimento:**
   ```bash
   ./mvnw quarkus:dev
   ```

3. **Acesse os endpoints da API** conforme documentado nos recursos do projeto.

## Testes

Para rodar os testes automatizados, utilize:
```bash
./mvnw test
```

## Organização do Projeto

- `src/main/java`: Código-fonte principal da API.
- `src/test/java`: Classes de teste automatizado.
- `src/main/resources`: Configurações do projeto e do banco de dados.

## Contribuição

Sinta-se à vontade para abrir issues ou pull requests com sugestões, correções ou melhorias.

## Licença

Este projeto está sob a licença MIT.

# toy-store-crud

<img src="https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExcGZmczRlazhyNTI2NjBzYmxqZ3phcGliazM5N3h4cThzY3Vpa3BoOCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/DSr5rDEaEZV9m/giphy.gif" width="300" height="200">

## Descrição 📖

Projeto de um CRUD de uma loja de brinquedos, onde é possível cadastrar, listar, atualizar e deletar brinquedos.

---
## Tecnologias 🛠️

- **Linguagens e Frameworks:**
    - Java 21
    - Spring Boot

- **Banco de Dados:**
    - PostgreSQL

- **Dependências:**
    - Lombok
    - Spring Data JPA
    - Spring Web
    - Springdoc OpenAPI
---
## Endpoints 🔗

- **GET**
    - **/toys** - Lista todos os brinquedos cadastrados
    - **/toys/{id}** - Lista um brinquedo específico pelo id
- **POST**
    - **/toys** - Cadastra um novo brinquedo
- **PUT**
    - **/toys/{id}** - Atualiza um brinquedo específico pelo id
- **DELETE**
    - **/toys/{id}** - Deleta um brinquedo específico pelo id

---
## Documentação 📚

Toda a documentação da API foi feita utilizando o Swagger.

- **Swagger:** http://localhost:8080/swagger-ui.html
___

## Banco de Dados 🗄️

O banco de dados utilizado foi o PostgreSQL, para rodar o projeto é necessário criar um banco de dados com o nome `toy_store` e configurar o arquivo `application.properties` com as credenciais do seu banco de dados.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/toy_store
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
Caso queira usar outro banco de dados, basta alterar a dependência no arquivo `pom.xml` e as configurações no arquivo `application.properties`.

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
___
## Como rodar o projeto 🚀

1. Clone o repositório
2. Abra o projeto em uma IDE de sua preferência
3. Faca um reload do Maven para baixar as dependências
4. Rode a aplicação
4. Acesse o Swagger para testar os endpoints
___
## Licença 📄

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.**




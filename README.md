# SENAI Clínica API

Projeto acadêmico de uma API para apoiar operações de gerenciamento de clínica médica, desenvolvido para praticar programação backend com Java e Spring Boot.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA e Hibernate
- MySQL
- Maven

## Funcionalidades

O projeto reúne operações de gerenciamento clínico e persistência de dados por meio de uma API. Consulte os controllers e serviços do código-fonte para verificar os endpoints disponíveis na versão atual.

## Como executar

### Pré-requisitos

- JDK compatível com a versão configurada no projeto
- Maven
- MySQL

Clone o repositório:

```bash
git clone https://github.com/GabrielVanderlinde/senai-clinica-api.git
cd senai-clinica-api
```

Configure a conexão com o banco de dados nas propriedades da aplicação. Exemplo ilustrativo:

```properties
spring.datasource.url=jdbc:mysql://localhost/clinica_db
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

> Os valores de banco de dados são exemplos. Ajuste-os ao seu ambiente e não versione credenciais reais.

## Objetivo

Praticar desenvolvimento de APIs, organização em camadas e persistência com o ecossistema Spring.

## Autor

Gabriel Vanderlinde
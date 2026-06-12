# BaoziStore API

API REST para gerenciamento de uma loja, desenvolvida como trabalho acadêmico. Permite o cadastro e gerenciamento de clientes, produtos e pedidos.

## Stack

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Data JPA / Hibernate | — |
| Spring MVC | — |
| Spring Validation (Jakarta) | — |
| MySQL | 8.0 |
| phpMyAdmin | latest |
| Docker / Docker Compose | — |
| Maven | — |

---

## Pré-requisitos

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/) (ou usar o wrapper `./mvnw`)
- [Docker](https://www.docker.com/) e Docker Compose

---

## Executando o projeto

### 1. Subir os contêineres do banco de dados

Na raiz do projeto, execute:

```bash
docker compose up -d
```

Isso irá iniciar dois contêineres:

| Contêiner | Serviço | Porta |
|---|---|---|
| `mysql-db` | Banco de dados MySQL | `3306` |
| `phpmyadmin` | Interface web do banco | `8081` |

### 2. Executar a aplicação Spring Boot

```bash
./mvnw spring-boot:run
```

Ou, se preferir gerar o JAR primeiro:

```bash
./mvnw package
java -jar target/BaoziStore-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em `http://localhost:8080`.

> **Atenção:** a propriedade `ddl-auto` está configurada como `create-drop`, o que significa que o schema do banco é recriado a cada inicialização e os dados são apagados ao encerrar a aplicação. Esse comportamento é intencional para o ambiente de desenvolvimento.

---

## Acessando o banco pelo browser

Com os contêineres no ar, acesse o phpMyAdmin em:

```
http://localhost:8081
```

### Credenciais de acesso

As credenciais estão definidas no `docker-compose.yml` e no `application.properties`:

| Campo | Valor |
|---|---|
| Servidor | `mysql-db` |
| Usuário | `admin` |
| Senha | `root` |
| Banco | `baozistore` |

---

## Endpoints da API

Todos os recursos seguem o padrão REST com os verbos abaixo:

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/cliente` | Criar cliente |
| `GET` | `/cliente` | Listar todos os clientes |
| `GET` | `/cliente/{id}` | Buscar cliente por ID |
| `PUT` | `/cliente/{id}` | Atualizar cliente |
| `DELETE` | `/cliente/{id}` | Remover cliente |
| `POST` | `/produto` | Criar produto |
| `GET` | `/produto` | Listar todos os produtos |
| `GET` | `/produto/{id}` | Buscar produto por ID |
| `PUT` | `/produto/{id}` | Atualizar produto |
| `DELETE` | `/produto/{id}` | Remover produto |
| `POST` | `/pedido` | Criar pedido |
| `GET` | `/pedido` | Listar todos os pedidos |
| `GET` | `/pedido/{id}` | Buscar pedido por ID |
| `PUT` | `/pedido/{id}` | Atualizar pedido |
| `DELETE` | `/pedido/{id}` | Remover pedido |

### Exemplos de payload

**Criar cliente** — `POST /cliente`
```json
{
  "nome": "João Silva"
}
```

**Criar produto** — `POST /produto`
```json
{
  "nome": "Baozi de Carne",
  "preco": 12.50,
  "estoque": true
}
```

**Criar pedido** — `POST /pedido`
```json
{
  "clienteId": 1,
  "produtoId": 1,
  "quantidade": 3
}
```

---

## Estrutura do projeto

```
src/main/java/drk/matheus/BaoziStore/
├── controller/       # Camada de entrada HTTP (REST)
├── service/          # Regras de negócio
├── repository/       # Acesso ao banco via JPA
├── entity/           # Entidades JPA (Cliente, Produto, Pedido)
├── dto/
│   ├── input/        # DTOs de entrada com validação
│   └── output/       # DTOs de saída para a resposta
├── mapper/           # Conversão entre entidades e DTOs
└── exception/        # Tratamento global de erros
```

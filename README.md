# Forum Hub 🧠💬

Projeto de um fórum de discussão desenvolvido com **Java** e **Spring Boot**, utilizando autenticação JWT, CRUD de tópicos e conexão com banco de dados.  
O objetivo é praticar os fundamentos do desenvolvimento web com **Spring**, **JPA**, **RESTful APIs** e **segurança com Spring Security**.

---

## 🛠 Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Hibernate**
- **MySQL**
- **Maven**

---

## ✅ Funcionalidades implementadas

- [x] Construção do banco de dados com MySQL
- [x] Autenticação com Spring Security
- [x] Geração de token JWT
- [x] Autenticação utilizando JWT
- [x] Cadastro de um novo tópico
- [x] Listagem de tópicos
- [x] Detalhamento de tópicos
- [x] Atualização de tópico
- [x] Exclusão de tópico
- [x] Testes dos endpoints da API
- [x] Atualização do repositório no GitHub

---

## 📦 Estrutura de pacotes principal

```bash
br.com.alura.forum_hub
├── domain          # Entidades de domínio (Topico, Curso, Usuario, etc)
├── controller      # Controllers REST
├── infra.security  # Autenticação, filtros, geração e validação de JWT
```

## 🔐 Autenticação JWT

Este projeto utiliza autenticação baseada em **JWT (JSON Web Token)** para proteger os endpoints da API.

### 🔄 Fluxo de autenticação

1. O usuário realiza login com email e senha através do endpoint:

   POST /login

2. Se as credenciais estiverem corretas, um token JWT é gerado e retornado no corpo da resposta.

3. Esse token deve ser enviado no header das próximas requisições autenticadas, da seguinte forma:

   Authorization: Bearer SEU_TOKEN_AQUI


## ▶️ Como executar o projeto localmente

### ✅ Pré-requisitos

- Java 17 ou superior
- Maven
- MySQL
- IDE como IntelliJ ou VS Code (opcional)

🧑‍💻 Autor
Gabriel Cardoso
GitHub - Cardosogoc

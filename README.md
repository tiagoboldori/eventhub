# EventHub

O **EventHub** é uma plataforma web desenvolvida em Java com Spring Boot para centralizar informações de eventos em uma única página acessível por meio de um QR Code.

O projeto nasceu com foco em eventos sociais, como casamentos, aniversários e confraternizações, mas foi concebido desde o início para suportar expansão para eventos corporativos e empresariais através de uma arquitetura modular.

---

## Funcionalidades

Atualmente o projeto contempla:

- Cadastro de usuários
- Login e autenticação com Spring Security
- Controle de sessão
- Cadastro de eventos
- Associação entre organizador e evento
- Persistência em PostgreSQL
- Migrações versionadas com Flyway
- Interface web utilizando Thymeleaf

---

## Tecnologias

### Backend

- Java 21
- Spring Boot 3
- Spring MVC
- Spring Data JPA
- Hibernate
- Bean Validation
- Flyway
- Maven

### Frontend

- HTML5
- CSS3
- Thymeleaf

### Banco de Dados

- PostgreSQL

---

## Estrutura

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── config
└── resources
    ├── templates
    ├── static
    └── db/migration
```

---

## Arquitetura

O projeto segue uma arquitetura em camadas para favorecer organização, manutenção e escalabilidade.

```
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

---

## Executando o projeto

### Pré-requisitos

- Java 21
- Maven
- PostgreSQL

### Clone o repositório

```bash
git clone https://github.com/tiagoboldori/eventhub.git
```

### Configure o banco

Edite o arquivo `application.yaml` com as credenciais do PostgreSQL.

### Execute

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

## Roadmap

Funcionalidades planejadas para as próximas versões:

- Login e controle de sessão (parcial)
- QR Code exclusivo por evento
- Upload de imagens
- Galeria de fotos
- RSVP (confirmação de presença)
- Lista de presentes
- Dashboard do organizador
- Módulos configuráveis por evento
- API REST
- Docker
- Deploy em produção

---

## Objetivos

O projeto foi desenvolvido priorizando:

- Código limpo (Clean Code)
- Baixo acoplamento
- Alta coesão
- Arquitetura modular
- Facilidade de manutenção
- Escalabilidade

---

## Autor

**Tiago Braga Boldori**

Graduando em Sistemas de Informação.

GitHub: https://github.com/tiagoboldori

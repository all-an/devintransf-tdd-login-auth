
## API REST para Controle de Conta, Cliente e Operações usando Spring Boot , TDD e Autenticação

### Requisitos:

- Java 11
- Spring Boot 2
- H2 Database
- JUnit 4
- Mockito
- Lombok 1.18
- PostgreSQL 12
- FlywayDB

### Executando:

```bash
git clone https://github.com/all-an/devintransf-tdd-login-auth.git
cd devintransf-tdd-login-auth
//Abrir com Spring Tools Suite
Acesse os endpoints através da url http://localhost:8080
```

### Exemplo body para POST inválido:

```json
{
    "name": "Allan Abrahão",
    "cpf": "1111111111",
    "email": "email inválido",
    "password": "12"
}
```

### Resposta recebida / esperada:

```json
{
    "data": null,
    "errors": [
        "Cpf Inválido!",
        "A senha deve conter no minimo 6 caracteres",
        "Email inválido"
    ]
}
```

### Exemplo de POST válido e resposta abaixo:

```json
{
    "name": "Allan Abrahão",
    "cpf": "coloque aqui o cpf válido",
    "email": "email@teste.com",
    "password": "1234567"
}
```

#### Resposta

```json
{
    "data": {
        "id": 1,
        "email": "email@teste.com",
        "name": "Allan Abrahão",
        "password": "1234567"
    },
    "errors": []
}
```
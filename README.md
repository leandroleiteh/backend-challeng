# API Backend-Challenge Itau

Uma aplicação Quarkus que expõe um endpoint REST para validação de tokens JWT de acordo com regras de negócio definidas.

---
## 🚀 Instruções de execução

### Pré-requisitos

* Java 21
* Maven 3.8+
* Docker (opcional)

### Build e execução local

```bash
# Clonar repositório
git clone https://github.com/leandroleiteh/backend-challenge.git
cd backend-challenge

# Compilar
mvn clean package

# Rodar em modo dev (hot reload)
mvn quarkus:dev
```

O serviço ficará disponível em `http://localhost:8080` ou `http://quarkus-app-alb-237966716.us-east-1.elb.amazonaws.com`

### Swagger UI

Acesse `http://localhost:8080/swagger-ui`
ou acesse `http://quarkus-app-alb-237966716.us-east-1.elb.amazonaws.com/swagger-ui/` para explorar a API e executar chamadas.

---

## 📡 Endpoint principal

### `POST /api/v1/jwt/validate`

Valida um token JWT conforme as regras:

1. Deve ser um JWT válido (formato e decodificação).
2. Contém exatamente 3 claims: `Name`, `Role` e `Seed`.
3. `Name` não pode conter dígitos e tem tamanho máximo de 256 caracteres.
4. `Role` deve ser um dos valores `Admin`, `Member` ou `External`.
5. `Seed` deve ser um número primo.

**Request**

```json
POST /api/v1/jwt/validate
Content-Type: application/json

{ "jwt": "<token>" }
```

**Responses**

* **200 OK** `{ "valid": "verdadeiro" }` quando o token atende a todas as regras.
* **400 Bad Request** `{ "valid": "falso" }` quando falha alguma verificação.

---

## 🧩 Estrutura de código e principais classes

### `JwtResource`

Implementa o contrato gerado pelo OpenAPI Codegen. Injeta `JwtValidationService` e retorna um `Response`:

* Lança `BadRequestException` se o payload for nulo.
* Usa status HTTP 200 ou 400 conforme o resultado.

### `JwtValidationServiceImpl`

Responsável pela lógica de validação:

1. Decodifica o token com `Auth0 JWT.decode`
2. Extrai claims para `Map<String,String>`
3. Aplica um **Predicate** que verifica:

    * Chaves exatamente iguais ao conjunto esperado.
    * Cada valor de claim satisfaz seu `ClaimValidator`.

### Enum `Claims` e `*Validator`

* `Claims` define as chaves e aponta para o validator correspondente.
* Cada validator (`NameValidator`, `RoleValidator`, `SeedValidator`) implementa `ClaimValidator`:

    * `NameValidator`: máximo 256 chars, apenas letras e espaços.
    * `RoleValidator`: valores permitidos `ADMIN`, `MEMBER`, `EXTERNAL`.
    * `SeedValidator`: converte para inteiro e testa primalidade.

---

## 🎯 Decisões de design

* **SOLID**: separação clara entre recurso (controller), serviço de validação e validações por claim.
* **EXTENSIBILIDADE**: novos tipos de claim podem ser adicionados criando outro enum validator.
* **COESÃO/ACOPLAMENTO**: cada classe tem responsabilidade única.
* **AUTOMAÇÃO DE CÓDIGO**: uso de OpenAPI Generator para gerar client stubs e modelos.

---

## 📦 Docker

Se preferir rodar em container:

```bash
docker build -f src/main/docker/Dockerfile.jvm -t backend-challenge .
docker run -p 8080:8080 backend-challenge
```

---

## 📜 Assunções

* Não há autenticação externa: qualquer JWT é recebido para validação.
* O campo `Seed` cabe em um inteiro Java sem estouro.
* Exceções de decodificação resultam em resposta `falso`.

---

## 🛠️ Testes

* **Unitários** para cada `*Validator`.
* **Integração** com Quarkus Test para o endpoint REST.

---

> Boa leitura e sucesso!

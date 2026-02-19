# 📊 API Duxus Desafio

API REST desenvolvida em **Spring Boot** para gerenciamento de Times,
Integrantes e estatísticas baseadas em períodos.

Inicialmente foi feito Teste de Mesa, implementações de testes e estrutura base da API

- Testes de endpoints realizados via Postman iniciando pelos controllers
- Implementação dos métodos necessários para atender regras de negócio
- Criação de services e DTOs de response
- Configuração de banco H2 em memória para persistência temporária
- Ajustes para validação das funcionalidades exigidas

------------------------------------------------------------------------

## 🚀 Como executar

``` bash
./mvnw spring-boot:run
```

Aplicação inicia em:

    http://localhost:8080

------------------------------------------------------------------------

## 🗄 Banco H2

Acesse:

    http://localhost:8080/h2-console

Credenciais:

    user: sa
    password:

------------------------------------------------------------------------

## ⚠️ Importante

Antes de testar endpoints analíticos, cadastre um time vencedor em "TimeVencedorSemena" (/localhost:8080/time/timeVencedorSemana).

------------------------------------------------------------------------

## 🧪 Criar Time Vencedor da Semana

**POST**

    /time/timeVencedorSemana

``` bash
curl -X POST http://localhost:8080/time/timeVencedorSemana \
  -H "Content-Type: application/json" \
  -d '{
    "nomeTime": "Dream Team",
    "data": "1994-01-10",
    "integrantes": [
      {"nome":"Jordan","funcao":"ala","franquia":"NBA"},
      {"nome":"Pippen","funcao":"ala","franquia":"NBA"},
      {"nome":"Rodman","funcao":"ala-pivô","franquia":"NBA"}
    ]
}'
```

------------------------------------------------------------------------

## 📌 Endpoints TimeController

### Criar Time

`POST /time/cadastroTime`

### Remover Time

`DELETE /time/removerTime/{id}`

### Criar Time Vencedor

`POST /time/timeVencedorSemana`

------------------------------------------------------------------------

## 📊 Endpoints ApiController

Formato de data:

    yyyy-MM-dd

### Time da Data

    GET api/timeDaData?ano=2026&mes=02&dia=15

### Integrante Mais Usado

    GET /api/integranteMaisUsado?dataInicial=2026-02-16&dataFinal=2026-03-17

### Integrantes do Time Mais Comum

    GET /api/integrantesDoTimeMaisComum?dataInicial=2026-02-10&dataFinal=2026-03-16

### Função Mais Comum

    GET /api/funcaoMaisComum?dataInicial=2026-02-16&dataFinal=2026-03-17

### Franquia Mais Famosa

    GET /api/franquiaMaisFamosa?dataInicial=2026-02-16&dataFinal=2026-03-17

### Contagem por Franquia

    GET /api/contagemPorFranquia?dataInicial=2026-02-16&dataFinal=2026-03-17

### Contagem por Função

    GET /api/contagemPorFuncao?dataInicial=2026-02-13&dataFinal=2026-03-16

------------------------------------------------------------------------

## 📥 Postman

Importe a collection:

    /colecao

------------------------------------------------------------------------

## 🧩 Arquitetura

    Controller → Service → Repository → Database

------------------------------------------------------------------------

## 🛠 Tecnologias

-   Java
-   Spring Boot
-   Spring Data JPA
-   H2
-   Maven

------------------------------------------------------------------------

## ✍️ Autor

Projeto para prática de API REST.

Nota: Existe o API.md com exemplos e descrições de chamadas.
Nota Importante: Existe o JSON do Postman que pode ser importado dentro da pasta: "colecao".
- Duxus\desafioDuxusEstagio\colecao

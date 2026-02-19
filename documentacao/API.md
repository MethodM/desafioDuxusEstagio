# 📘 Documentação da API — Duxus Desafio

Documentação dos controllers **TimeController** e **ApiController** responsáveis pelo gerenciamento de times e consultas estatísticas.

---

# 📂 Base URL

```
http://localhost:8080
```

---

# 🧩 Controller: `/time`

Responsável por operações de cadastro e gerenciamento de times.

---

## ➕ Criar Time

**POST** `/time/cadastroTime`

### Body

```json
{
  "nomeTime": "Chicago Bulls",
  "data": "1993-06-20"
}
```

### Resposta

```json
"Time salvo com sucesso!"
```

---

## ❌ Remover Time

**DELETE** `/time/removerTime/{id}`

### Exemplo

```
/time/removerTime/1
```

### Resposta

```json
"Time removido com sucesso"
```

---

## 🏆 Cadastrar Time Vencedor da Semana

**POST** `/time/timeVencedorSemana`

### Body

```json
{
  "nomeTime": "Dream Team",
  "data": "1994-01-10",
  "integrantes": [
    {
      "nome": "Jordan",
      "funcao": "ala",
      "franquia": "NBA"
    }
  ]
}
```

### Fluxo interno

1. Cria time
2. Cria ou busca integrante
3. Cria composição time-integrante

⚠️ **Observação:** endpoint ainda não retorna resposta (TODO no código).

---

---

# 📊 Controller: `/api`

Responsável por consultas e estatísticas.

---

## 📅 Time de uma data específica

**GET** `/api/timeDaData?dia=20&mes=6&ano=1993`

### Resposta

```json
{
  "data": "1993-06-20",
  "nomeTime": "Chicago Bulls",
  "integrantes": [
    {
      "nome": "Jordan",
      "funcao": "ala",
      "franquia": "NBA"
    }
  ]
}
```

---

## 👤 Integrante mais usado

**GET**

```
/api/integranteMaisUsado?dataInicial=1993-01-01&dataFinal=1995-12-31
```

### Retorno

```json
{
  "nome": "Jordan",
  "funcao": "ala",
  "franquia": "NBA"
}
```

---

## 👥 Integrantes do time mais comum

**GET**

```
/api/integrantesDoTimeMaisComum?dataInicial=1993-01-01&dataFinal=1995-12-31
```

### Retorno

```json
[
  "Jordan",
  "Pippen",
  "Rodman"
]
```

---

## 🧠 Função mais comum

**GET**

```
/api/funcaoMaisComum?dataInicial=1993-01-01&dataFinal=1995-12-31
```

### Retorno

```json
"ala"
```

---

## ⭐ Franquia mais famosa

**GET**

```
/api/franquiaMaisFamosa?dataInicial=1993-01-01&dataFinal=1995-12-31
```

### Retorno

```json
"NBA"
```

---

## 📈 Contagem por Franquia

**GET**

```
/api/contagemPorFranquia?dataInicial=1993-01-01&dataFinal=1995-12-31
```

### Retorno

```json
{
  "NBA": 2
}
```

---

## 📊 Contagem por Função

**GET**

```
/api/contagemPorFuncao?dataInicial=1993-01-01&dataFinal=1995-12-31
```

### Retorno

```json
{
  "ala": 2,
  "ala-pivô": 1
}
```

---

---

# 🧪 Formato de Datas

Todos endpoints que usam datas seguem padrão:

```
yyyy-MM-dd
```

Exemplo:

```
1993-06-20
```

---

# ⚙️ Dependências Internas

Os controllers dependem de:

* `TimeService`
* `IntegranteService`
* `ComposicaoTimeService`
* `ApiService`
* `TimeRepository`

---

# 📌 Observações

* Todos endpoints retornam **HTTP 200** quando sucesso.
* Validações de erro devem ser tratadas no service layer.
* Métodos estatísticos dependem da lista retornada por `timeRepository.findAll()`.

---

# 🚀 Status do Projeto

✔ Cadastro de times
✔ Consultas estatísticas
⚠ Endpoint de vencedor da semana ainda sem retorno

---

---

# 👨‍💻 Autor

Projeto desenvolvido para desafio técnico com arquitetura:

```
Controller → Service → Repository → Model
```

---

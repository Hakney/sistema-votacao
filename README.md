# 🗳️ Sistema de Votação com RabbitMQ, Spring Boot e PostgreSQL

Este projeto é um **sistema de votação** desenvolvido com o objetivo de **praticar os conceitos de mensageria utilizando RabbitMQ**, juntamente com **Spring Boot** para o backend e **PostgreSQL** como banco de dados relacional.

---

## 🛠️ Tecnologias Utilizadas

- ✅ Java 17  
- ✅ Spring Boot  
- ✅ RabbitMQ  
- ✅ PostgreSQL  
- ✅ Maven  

---

## 📌 Objetivo do Projeto

O foco principal deste sistema é explorar e aplicar os conceitos de **fila de mensagens com RabbitMQ**, criando um fluxo assíncrono para o processamento de votos.

O sistema simula uma votação onde os votos são enviados para uma fila e, posteriormente, processados e armazenados no banco de dados.

---

## 🔄 Fluxo da Aplicação

1. O usuário envia um voto através de uma requisição HTTP.
2. O voto é publicado em uma **fila do RabbitMQ**.
3. Um **consumer** escuta a fila e processa o voto.
4. O voto é salvo no **banco de dados PostgreSQL**.

---

## 🚀 Como Executar o Projeto

### 1. Subir os containers do RabbitMQ e PostgreSQL

Certifique-se de ter o Docker instalado. Depois, no terminal, execute:

```bash
docker-compose up -d
```

### 2. Rodar a aplicação Spring Boot

Execute o projeto spring boot na IDE de sua preferência.

---

## 🧪 Possibilidades de Testes

### ✅ Enviar votos via Postman

- **URL:** `http://localhost:8080/api/voto`  
- **Método:** `POST`  
- **Headers:**  
  - `Content-Type: application/json`

- **Exemplo de Body (JSON):**

```json
{
  "idCandidato": 1
}
```
---

## ✅ Verificações que podem ser feitas

- 📬 **RabbitMQ**: Acompanhar o recebimento das mensagens na interface web do RabbitMQ em [`http://localhost:15672`](http://localhost:15672).  
  *(Usuário padrão: `guest`, Senha: `guest`)*

- 📄 **Console da Aplicação**: Observar o processamento assíncrono das mensagens no log da aplicação Spring Boot.

- 🗃️ **Banco de Dados**: Verificar os votos salvos no PostgreSQL utilizando ferramentas como **pgAdmin**, **DBeaver**, ou através de comandos SQL como:

```sql
SELECT * FROM votos;
```

---

## 🎯 Objetivo

O principal objetivo é praticar:

- Criação e uso de **filas**, **exchanges** e **bindings** com RabbitMQ  
- Processamento assíncrono de mensagens  
- Persistência em banco de dados com PostgreSQL  
- Integração com Spring Boot

---

## 🔄 Funcionamento do Sistema

1. O usuário envia um voto via API (`/api/voto`).
2. O voto é publicado na exchange `computar.vot.ex`.
3. A exchange redireciona o voto para a fila `computar.voto.queue`
4. Criar um binding no menu Queues and Streams: computar.voto.ex
5.Um **consumer** escuta a fila e processa o voto.
O voto é armazenado no banco de dados PostgreSQL.

---

## 🧩 Componentes do RabbitMQ

- **Exchange**: `computar.voto.ex` (tipo: direct)  
- **Queue**: `computar.voto.queue`

---
## 📚 Aprendizados

Durante o desenvolvimento deste projeto, foram explorados os seguintes conceitos:

- 🔁 Comunicação assíncrona utilizando **RabbitMQ**
- 🛠️ Configuração de **filas**, **exchanges** e **bindings**
- 📦 Serialização e envio de mensagens **JSON**
- 🧾 Criação de **consumers** para processar as mensagens recebidas
- 💾 Persistência de dados no **PostgreSQL**
- 📡 Integração entre **Spring Boot** e **RabbitMQ**

---

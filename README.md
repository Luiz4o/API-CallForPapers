# API-CallForPapers

 Introdução

Esta API fornece um CRUD para Propostas, além de métodos para criação de usuários e autenticação via JWT.

Requisitos

Para rodar esta aplicação, é necessário ter os seguintes componentes instalados:

MySQL

JDK 21 (preferencialmente)

Maven (para gerenciamento de dependências)

Postman ou Insomnia (para testar as requisições)

Configuração e Execução

1. Clonar o Repositório

Clone o repositório do projeto para sua máquina local:

git clone https://github.com/Luiz4o/API-CallForPapers.git

2. Atualizar Dependências do Maven

Certifique-se de que todas as dependências estão atualizadas:

mvn clean install

3. Configurar Banco de Dados

Atualize as configurações do MySQL no arquivo application.properties:

spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

Crie um banco de dados com o nome desafiocfp:

CREATE DATABASE desafiocfp;

4. Executar a Aplicação

Rodar o projeto com o seguinte comando:

mvn spring-boot:run

A aplicação será iniciada na porta 8080. Caso essa porta esteja em uso, altere a configuração no application.properties.

5. Autenticação

A API utiliza autenticação via JWT, então é necessário realizar login antes de acessar os endpoints protegidos.

Um usuário de teste já foi inserido automaticamente:

Login: teste

Senha: teste

6. Front End:

Caso queira ver toda a experiência aqui está disponibilizado o FrontEnd da aplicação que pode ser utilizado junto desta API

Link github : https://github.com/Luiz4o/CallForPapers-Angular

Endpoints Disponíveis

POST : http://localhost:8080/user/register
EX REQ:  
    {
      "login":"teste",
      "senha":"teste"
    }

POST : http://localhost:8080/user/login
EX REQ:  
    {
      "login":"teste",
      "senha":"teste"
    }
OBS : O retorno desta requisição contém o Bearer token necessário para autenticação

GET : http://localhost:8080/propostas
AUTH : BEARER TOKEN

GET : http://localhost:8080/propostas/:id
AUTH : BEARER TOKEN

POST : http://localhost:8080/propostas
EX REQ:  
    {
	    "title": "teste",
     	"summary": "teste",
	    "author": "teste",
	    "email": "teste"
    }
AUTH : BEARER TOKEN

PUT : http://localhost:8080/propostas
EX REQ:  
    {
      "id":1,
	    "title": "OPTIONAL",
     	"summary": "OPTIONAL",
	    "author": "OPTIONAL",
	    "email": "OPTIONAL"
    }
AUTH : BEARER TOKEN

DELETE : http://localhost:8080/propostas/:id
AUTH : BEARER TOKEN


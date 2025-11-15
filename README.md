PROJETO PORTAL DE ESTÁGIOS
Backend em Spring Boot + H2
Frontend em React

⸻

	1.	INTRODUÇÃO

Este projeto implementa um Portal de Estágios com autenticação JWT, perfis de usuário (Administrador, Empresa e Estudante), CRUD de entidades principais, geração de currículo em PDF e dashboard administrativo. O backend utiliza Spring Boot com banco de dados H2 em memória. O frontend foi criado com React (Create React App).

⸻

	2.	PRÉ-REQUISITOS

Para executar o projeto é necessário possuir:
	•	Java 21
	•	Maven 3.8 ou superior
	•	Node.js 18 ou superior
	•	NPM ou Yarn
	•	GitHub Codespaces ou ambiente local configurado

⸻

	3.	EXECUÇÃO DO BACKEND

Entrar na pasta do backend:

cd portal-estagios

Executar o build:

mvn clean install

Iniciar a aplicação:

mvn spring-boot:run

A aplicação será iniciada em:

http://localhost:8080

ou no caso do Codespaces:

https://SEU-CODESPACE-8080.app.github.dev

⸻

	4.	CREDENCIAIS PADRÃO

Ao iniciar o sistema, um usuário administrador é criado automaticamente pelo DataLoader:

Login: admin
Senha: admin123
Papel: ROLE_ADMIN

⸻

	5.	ENDPOINTS PRINCIPAIS

Autenticação
POST /auth/login

Administrador
GET /admin/dashboard

Áreas
GET /areas
POST /areas
PUT /areas/{id}
DELETE /areas/{id}

Empresas
GET /empresas
POST /empresas

Estudantes
GET /estudantes
POST /estudantes

Vagas
GET /vagas
GET /vagas/abertas
POST /vagas
PUT /vagas/{id}
PUT /vagas/{id}/encerrar

Inscrições
POST /inscricoes

Currículo em PDF
GET /curriculos/{idEstudante}

Swagger
http://localhost:8080/swagger-ui/index.html
ou
https://SEU-CODESPACE-8080.app.github.dev/swagger-ui/index.html

⸻

	6.	EXECUÇÃO DO FRONTEND

Entrar na pasta:

cd portal-estagios-frontend

Instalar dependências:

npm install

Executar o projeto:

npmstart

O sistema inicia por padrão em:

http://localhost:3000

ou no Codespace:

https://SEU-CODESPACE-3000.app.github.dev

⸻

	7.	CONFIGURAÇÃO DO FRONTEND PARA O BACKEND

Arquivo:

src/api/api.js

Deve conter:

import axios from “axios”;

const api = axios.create({
baseURL: “https://SEU-CODESPACE-8080.app.github.dev”
});

export default api;

A URL deve sempre apontar para a porta 8080 do Codespace.

⸻

	8.	PROBLEMAS COMUNS E SOLUÇÕES

8.1 HTTP 403 no backend
Causa: JWT ausente ou inválido.
Solução: efetuar login pelo frontend, armazenar token e reenviar nas requisições.

8.2 Erro CORS
Solução: adicionar o endereço completo do frontend em CorsConfig.

8.3 Tela branca no React
Causa: import errado, nome de arquivo incorreto, caminho incorreto.
Solução: verificar mensagens do navegador, ajustando:

import CadastrarVaga from “./pages/empresa/CadastrarVaga”;

O nome do arquivo deve coincidir exatamente com o import, inclusive maiúsculas.

8.4 WebSocket connection failed
Este erro aparece no Codespaces devido ao hot reload. Não afeta o funcionamento da aplicação.

8.5 Dashboard retornando 404
Causa: endpoint chamado incorretamente no frontend.
Solução: utilizar exatamente:

GET /admin/dashboard

8.6 Login redireciona para /painel mas não existe rota
Solução: ajustar o App.js ou redirecionar para /admin, /empresa ou /estudante dependendo do papel.

⸻

	9.	ROTAS DO FRONTEND

Login
/login

Administrador
/admin
/areas

Empresa
/empresa
/empresa/cadastrar-vaga
/empresa/minhas-vagas

Estudante
/estudante
/estudante/vagas
/estudante/pdf

⸻

	10.	ESTRUTURA DAS PASTAS

Backend (Spring Boot)
portal-estagios/
src/main/java/br/mack/estagios/
config/
controller/
dao/
model/
repository/
service/
EstagiosApplication.java
src/main/resources/
application.properties
pom.xml

Frontend (React)
portal-estagios-frontend/
src/
api/
pages/
App.js
index.js
package.json

⸻

	11.	COMO GERAR PDF

Requisição:

GET /curriculos/{idEstudante}

Baixa automaticamente um PDF com nome, curso, contato e áreas de interesse do estudante.

⸻

	12.	CONSIDERAÇÕES FINAIS

Este projeto já possui todas as funcionalidades exigidas pelo enunciado:
	•	autenticação JWT;
	•	CRUD completo das entidades principais;
	•	dashboards;
	•	geração de currículo em PDF (funcionalidade inovadora);
	•	separação entre backend e frontend;
	•	restrição de rotas por papel;
	•	integrações funcionando via fetch e axios.
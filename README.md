# 📦 Sistema CadastroEE

**Trabalho Prático - DGT2811: Desenvolvimento Back-End Corporativo com Java e Cloud**

Este projeto é um sistema corporativo web para o cadastro e gerenciamento de produtos. Ele foi desenvolvido utilizando a arquitetura Java EE (Jakarta EE), separando as responsabilidades em camadas de persistência, controle (regras de negócio) e apresentação.

## 🚀 Tecnologias Utilizadas
* **Back-end:** Java / Jakarta EE, EJB (Enterprise JavaBeans), JPA (Java Persistence API)
* **Front-end:** JSF (JavaServer Faces), HTML5, CSS3, Bootstrap 5
* **Banco de Dados:** Microsoft SQL Server (via Docker)
* **Servidor de Aplicação:** GlassFish Server 6.x
* **IDE:** Apache NetBeans

## ⚙️ Funcionalidades (CRUD Completo)
* [x] **Read:** Listagem dinâmica de produtos cadastrados com formatação de valores.
* [x] **Create:** Inclusão de novos produtos via formulário validado.
* [x] **Update:** Edição de dados existentes (Nome, Quantidade e Preço).
* [x] **Delete:** Exclusão de registros diretamente do banco de dados com alerta de segurança.

## 🛠️ Como testar o projeto
1. Clone este repositório para a sua máquina.
2. Certifique-se de que o contêiner do SQL Server está rodando e o banco `loja` está criado.
3. Configure o pool de conexões no GlassFish (JDBC Resource: `jdbc/loja`).
4. Abra o projeto pai (`CadastroEE`) no Apache NetBeans.
5. Execute o comando `Clean and Build`.
6. Faça o deploy do arquivo `.ear` no servidor GlassFish.

---
*Desenvolvido como requisito de avaliação da disciplina.*

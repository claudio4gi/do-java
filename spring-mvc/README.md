# Projeto de exemplo para servidor REST

Requisitos
---
- Java 8
- MongoDb (Na nuvem com https://mlab.com/)

Montagem de ambiente
---
- Clonar repo master
- Importar projeto Gradle na IDE (Eclipse, Intellij)
- Configurar o arquivo de conexão com banco de dados `application.properties`

Executar o server
---
- Classe principal `ExampleApplication`
- Package `br.com.example.model` das entidades
- Package `br.com.example.repository`  com o repositório das entidades
- Package `br.com.example.controller` com o controller da entidade `Master`
- Package `br.com.example.service.rest` com o serviço da entidade `Master`



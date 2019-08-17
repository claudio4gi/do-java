Objetivo
---
Estudo das seguintes tecnologias e metodologias:
- Database RDS (AWS)
- Docker
- Kubernetes
- Security
- Swagger
- Clean Code

Base de dados
---
Para banco de dados foi utilizado o PostgreSQL RDS da AWS, com isso, nenhuma configuração de base de dados é necessária para testar esta API.

Docker
---
```
docker run -p8080:8080 jclaudiocf/invillia:latest -d
```

Kubernetes
---
```
kubectl create -f kubernetes.yaml
```

Swagger
---
Para consultar a documentação técnica da API basta acessar a URL http://localhost:8080/swagger-ui.html.

API
---
Request para autenticação:
Método: POST

URL: http://localhost:8080/login

Dados de entrada: {"email" : "admim@admin.com.br", "password" : "admin"}

Demais requests na documentação do Swagger.

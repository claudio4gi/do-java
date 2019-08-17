# Projeto
Este projeto visa a autenticação de usuários utilizando o Spring boot, Spring security, JWT e base MongoDB.

# Base de dados
Foi utilizado o projeto [mLab](https://mlab.com/) para o armazenamento de dados com MongoDB cloud, com isso, nenhuma configuração de base de dados será necessária.

# Docker
O projeto está publicado no Docker e pode ser executado com o comando abaixo.

```sheel
docker run -p8090:8090 jclaudiocf/authentication -d
```

> Nota: Usar a porta 8090 que foi fixamente imposta.

# Kubernetes
Para executar o projeto em um orquestrador basta importar o arquivo kubernetes.YAML contido no raiz do repo.

# Contribuição
Caso esteja interessado em contribuir com o projeto segue algumas orientações e comandos do ambiente dev.

* Clonar o repo
* Importar o projeto maven em sua IDE
* Realizar a contribuição

Para compilar e testar sua compilação
```sheel
mvnw package
```

> Nota: A saída, caso sucesso, será um JAR na pasta *target/*.

Para publicar a alteração no Docker
```shell
mvnw install dockerfile:push
````
> Nota: Favor entrar em contato para solicitar a autenticação para a publicação no DockerHub.

# Endpoints

> Nota: Todos os endpoints são protegidos por autenticação, com isso, utilize o endpoint *login* para se autenticar.

> Leia {seu IP} onde localizar *localhost*.

_Login de usuário._

POST : http://localhost:8090/login

input:
```
{
	"email" : "user@gmail.com",
	"password" : "user"
}
```

output: Retorno do Authorization no headers.

---

_Realiza uma busca por cadastros de usuários._

GET : http://localhost:8090/user/search

input:
```
{
	"user" : {
		"name" : "claudio",
		"address" : "rua"
	},
	"page" : 0,
	"size" : 100,
	"direction" : "ASC",
	"fields" : [ "name", "address" ]
}
```
> Nota: Todos os parâmetro de entrada são opcinais.

output:
```
{
    "content": [
        {
            "id": "5c410fe01de11890fc447d66",
            "name": "claudio",
            "email": "jclaudiocf@gmail.com",
            "password": "{bcrypt}$2a$10$k5Q6MlTo4JoizpF8lpyy/uB.Fo.JPzUVqolXJkNBSRYleAc8I6kX.",
            "address": "rua",
            "phone": "numero",
            "profile": "ADMIN",
            "enabled": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "authorities": null,
            "accountNonExpired": true,
            "username": "jclaudiocf@gmail.com"
        },
        {
            "id": "5c412a9e1de1189281eaa25d",
            "name": "claudio",
            "email": "sem@gmail.com",
            "password": "{bcrypt}$2a$10$aTMMS2GNEYSb7HUtg8SGl.HKoyrx3xoS0etWJAvT9qvfuUmJmvxSe",
            "address": "rua",
            "phone": "numero",
            "profile": "ADMIN",
            "enabled": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "authorities": null,
            "accountNonExpired": true,
            "username": "sem@gmail.com"
        },
        {
            "id": "5c412ab01de1189281eaa25e",
            "name": "claudio",
            "email": "user@gmail.com",
            "password": "{bcrypt}$2a$10$RNss9YJLUfl0MmzBp2hQe.e0LHhWH59xcT3BseeQ1DIjUmrX0oRzy",
            "address": "rua",
            "phone": "numero",
            "profile": "USER",
            "enabled": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "authorities": null,
            "accountNonExpired": true,
            "username": "user@gmail.com"
        }
    ],
    "pageable": {
        "sort": {
            "unsorted": false,
            "sorted": true,
            "empty": false
        },
        "pageSize": 100,
        "pageNumber": 0,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 3,
    "last": true,
    "sort": {
        "unsorted": false,
        "sorted": true,
        "empty": false
    },
    "numberOfElements": 3,
    "first": true,
    "size": 100,
    "number": 0,
    "empty": false
}
```
---

_Salva um novo usuário._

POST : http://localhost:8090/user

input:
```
{
	"name" : "claudio",
	"email" : "user@gmail.com",
	"password" : "user",
	"address" : "address",
	"phone" : "phone",
	"profile" : "USER"
}
```

> Nota: O campo profile aceita USER ou ADMIN, onde o usuário adm terá maiores acessos.

> Para atualizar os dados do usuário basta mudar o verbo para PUT.

output: O usuário salvo.

---

_Retorna um usuário salvo._

GET : http://localhost:8090/user/{id}

output:
```
{
    "id": "5c410fe01de11890fc447d66",
    "name": "claudio",
    "email": "adm@gmail.com",
    "password": "{bcrypt}$2a$10$k5Q6MlTo4JoizpF8lpyy/uB.Fo.JPzUVqolXJkNBSRYleAc8I6kX.",
    "address": "rua",
    "phone": "numero",
    "profile": "ADMIN",
    "enabled": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true,
    "authorities": null,
    "accountNonExpired": true,
    "username": "adm@gmail.com"
}
```
> Nota: Para deletar um usuário basta usar o verbo DELETE.









# java-mongo-docker
Projeto de estudo sobre docker. 
A intencão é desenvolver uma API Rest simples utilizando Springboot, mongoDB e criar uma imagem com o docker compose.

GET - localhost:8080/api -> Boas vindas

GET - localhost:8080/api/pessoas -> Retornar a lista de pessoas

GET - localhost:8080/api/pessoas/{id} -> Retorna uma pessoa pelo id

POST - localhost:8080/api/pessoas {"nome":"teste", "sobrenome":"teste"} -> salvar uma pessoa

DELETE - GET - localhost:8080/api/pessoas/{id} -> Deleta uma pessoa pelo id

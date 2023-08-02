# prova_confidence_str
Teste de manipular str e OO

Dada uma classe Cliente, uma classe Gerente e uma classe Robo, todas devem ter um nome no qual deve atender aos seguintes requisitos: Não é necessário expor um serviço, queremos ver a lógica e organização

* Nome não pode ser nulo
* Nome não pode ser vazio
* Nome não pode conter espaços extras no início e no fim
* Deve ser possível obter o primeiro nome. Exemplo: Se o nome for "João Soares Silva", deve retornar "João".
* Retornar o último nome. Exemplo: Se o nome for "João Soares Silva", deve retornar "Soares Silva".
* Retornar o nome todo em letras maiúsculas.
* Retornar o nome abreviado. Exemplo: Se o nome for "João Soares Silva", retornar "João S. Silva".

# Instalação
após fazer o clone do projeto, em uma maquina que possua maven instalado e java 11+, execute o comando mvn clean install, após compilar, basta ir até o diretório /target e rodar o comando java -jar nomeDoProjeto.jar

# Para acessar o swagger
http://localhost:8080/swagger-ui/index.html

# Para Postman
curl --location --request POST 'localhost:8080/pessoa/?nome=Andrelino%20Martins%20de%20Souza&tipoPessoa=GERENTE'

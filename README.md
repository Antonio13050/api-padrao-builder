# API Padrao Builder

Este projeto é uma API para cadastro de usuários que aplica o padrão de projeto Builder. A API é dockerizada, o que significa que pode ser facilmente executada em qualquer ambiente compatível com Docker.

## Como Executar

Para executar a API, siga estas etapas:

1. Certifique-se de ter o Docker instalado em sua máquina.

2. Clone este repositório para o seu ambiente local.

3. Abra um terminal e navegue até o diretório raiz do projeto.

4. Execute o seguinte comando para iniciar a API:
 ```bash
   docker-compose up
````
5. Após a execução bem-sucedida, você poderá acessar a API em http://localhost:8080.

## Endpoints

A API possui os seguintes endpoints:

- `GET /person/{id}`: Retorna as informações de um usuário específico com o ID fornecido.
- `POST /person`: Cria um novo usuário com os dados fornecidos no corpo da solicitação. Os dados devem ser enviados em formato JSON.

## Padrão RESTful

Esta API segue o padrão RESTful para a criação de endpoints. Isso significa que os endpoints são projetados para serem intuitivos e seguirem as melhores práticas de design de APIs REST.

## Licença

Este projeto está licenciado sob a [Licença MIT](/LICENSE).
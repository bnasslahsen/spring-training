### RUN MYSQL From Docker

- [Documenting a Spring REST API Using OpenAPI 3.0](https://www.baeldung.com/spring-rest-openapi-documentation)

- To start MySQL locally

```sh
docker run --name mysql-dev -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=formationdb -d -p 3306:3306 mysql:latest
```

- To test the application: try http://localhost:8081/items or http://localhost:8081/addOrder


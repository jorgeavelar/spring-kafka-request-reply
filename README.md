# Synchronous Request-Reply with Spring Boot and Kafka

 This example demonstrates spring-kafka using request-reply semantics.

## Requirements
* Java 11+
* Maven 3+
* Apache Kafka
* Lombok
* Docker Compose (optional but preferred)

## Running
To start this app:
* Start kafka with compose 'docker-compose up'
* Start server running './mvnw spring-boot:run'

## How to test
Open you console and enter command below:

```
curl -X POST  http://localhost:8080/coffee/create -d '{"varietal": "Yellow Bourbon","quantity": 5, "price": 30.00}' -H "Content-Type: application/json" | python -m json.tool

```

Response:
```
{
    "id": "34ff3987-aa3f-4e8b-8d92-f43d80849e6c",
    "price": 30.0,
    "varietal": "Yellow Bourbon",
    "quantity": 5,
    "amount": 150.0
}
```

## Maintainers
[Jorge Avelar](mailto:jorge.avelar@summa.com)

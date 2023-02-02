# ParadigmBookStore

## Description
This is a simple bookstore application that allows users to add books to their cart and checkout. It is built using the following technologies:
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- Spring Web

## Installation
- Clone the repository
- Run `mvn clean install` to install the dependencies
- Run `mvn spring-boot:run` to start the application
- Navigate to `http://localhost:8081` to access the application
- Navigate to `http://localhost:8081/swagger-ui.html` to access the Swagger API documentation
- Navigate to `http://localhost:8081/v2/api-docs` to access the Swagger API documentation in JSON format

## Usage
- Navigate to `http://localhost:8081` to access the application
 ```
POST api/v1/book                    GET BOOK
GET  api/v1/book/search             SEARCH BOOKS
GET  api/v1/book/list/              LIST BOOKS
GET  api/v1/book/list/{title}       LIST BOOKS BY TITLE
GET  api/v1/book/list/{bookStatus}  LIST BOOKS BY STATUS
POST api/auth/login                 LOGIN
```
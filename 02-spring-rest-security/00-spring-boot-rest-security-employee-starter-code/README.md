# Employee Management REST API

A Spring Boot REST API for managing employees with role-based authorization using Spring Security.

## Features

* Spring Boot 3
* Spring Data REST
* Spring Security
* In-Memory Authentication
* Role-Based Authorization
* CRUD Operations
* HTTP Basic Authentication

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data REST
* Maven
* MySQL

## Running the Application

### Clone Repository

```bash
git clone <repository-url>
cd cruddemo
```

### Run Application

```bash
mvn spring-boot:run
```

Application starts at:

```text
http://localhost:8080
```

## User Credentials

| Username | Password | Roles                    |
| -------- | -------- | ------------------------ |
| John     | test123  | EMPLOYEE                 |
| Mary     | mary123  | EMPLOYEE, MANAGER        |
| Susan    | susan123 | EMPLOYEE, MANAGER, ADMIN |

## API Authorization Matrix

| Method | Endpoint            | Authorized Role |
| ------ | ------------------- | --------------- |
| GET    | /api/employees      | EMPLOYEE        |
| GET    | /api/employees/{id} | EMPLOYEE        |
| POST   | /api/employees      | MANAGER         |
| PUT    | /api/employees      | MANAGER         |
| PATCH  | /api/employees/{id} | MANAGER         |
| DELETE | /api/employees/{id} | ADMIN           |

## Authentication

The API uses HTTP Basic Authentication.

Example Header:

```text
Authorization: Basic <base64(username:password)>
```

## Example Requests

### Get Employees

```http
GET /api/employees
```

### Create Employee

```http
POST /api/employees
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com"
}
```

## Security Configuration

* HTTP Basic Authentication enabled
* CSRF disabled for REST APIs
* Role-based endpoint protection
* In-memory user authentication

## Testing

Use Postman and provide Basic Authentication credentials from the User Credentials table above.

## Author

Saniya Bagwan

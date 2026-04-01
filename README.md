# Memo API Project

A simple CRUD API for managing memos.
This project is built using Spring Boot and demonstrates core backend concepts such as DTO, validation, exception handling, and standardized API responses.

---

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* H2 Database (or MySQL)
* Gradle

---

## Features

* Create memo
* Read memo list
* Update memo
* Delete memo

---

## API Structure

### Unified Response Format

All API responses follow a consistent structure:

```json
{
  "success": true,
  "data": {},
  "error": null
}
```

---

## Key Concepts

### DTO

* Prevents exposing internal entity directly
* Separates request and response models from database structure

### Validation

* Uses `@Valid` and validation annotations
* Returns `400 Bad Request` for invalid input

### Exception Handling

* Centralized handling using `@RestControllerAdvice`
* Provides consistent error responses

### API Response Standardization

* All responses are wrapped in a unified format for consistency

---

## API Endpoints

| Method | Endpoint   | Description   |
| ------ | ---------- | ------------- |
| POST   | /memo      | Create memo   |
| GET    | /memo      | Get memo list |
| PUT    | /memo/{id} | Update memo   |
| DELETE | /memo/{id} | Delete memo   |

---

## What I Learned

* Understanding of request → service → repository flow
* Importance of validation in API design
* How exception handling improves API stability
* Structuring clean and maintainable backend code

---

## Repository

https://github.com/eugene3367/pro0313

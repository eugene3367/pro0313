# Memo API (Spring Boot)

## Project Overview
This project is a Memo API built with Spring Boot.  
It implements core backend features including authentication, authorization, and exception handling using JWT.

---

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL (Render)
- JWT (JSON Web Token)
- BCrypt (Password Encryption)

---

## Features

### Authentication
- User signup with password encryption (BCrypt)
- User login with JWT token generation
- JWT-based authentication filter

### Security
- Encrypted password storage
- JWT token validation
- Protected API endpoints

### Exception Handling
- Global exception handler
- Custom exception handling
- Input validation using @Valid and @NotBlank

---

## API Examples

### Signup
POST /auth/signup

Request:
{
"username": "test",
"password": "1234"
}

---

### Login
POST /auth/login

Request:
{
"username": "test",
"password": "1234"
}

---

### Authenticated Request
Authorization: Bearer {JWT_TOKEN}

---

## What I Learned
- How JWT authentication works in backend systems
- How to securely store passwords using BCrypt
- How to design a global exception handling structure
- How to validate request data using Spring Validation

---

## Next Steps
- Implement memo CRUD features
- Associate memos with authenticated users
- Improve API structure and refactor code
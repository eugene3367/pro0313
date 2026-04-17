# Memo API Project

## Overview
This project is a backend REST API built with Spring Boot.  
It provides user authentication and memo management functionality.

---

## Features

### Authentication
- User signup
- User login with JWT authentication

### Memo Management
- Create memo
- Update memo
- Delete memo
- Get user's memos

### Advanced Features
- Pagination support
- Sorting support
- Keyword-based search
- Unified API response structure
- Global exception handling

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- JWT Authentication

---

## API Endpoints

### Auth

POST /auth/signup  
POST /auth/login

---

### Memo

POST /memo  
GET /memo  
PUT /memo/{id}  
DELETE /memo/{id}

---

## Query Parameters (GET /memo)

- page: page number (default: 0)
- size: number of items per page
- sort: sorting field and direction (e.g., id,desc)
- keyword: search keyword (optional)

Example:

GET /memo?page=0&size=5&sort=id,desc  
GET /memo?keyword=hello&page=0&size=5

---

## Response Format

```json
{
  "success": true,
  "data": {},
  "error": null
}
```

### Project Structure

Controller → Service → Repository → Entity
DTO is used for request and response mapping.

---

## Future Improvements

* AWS deployment
* Docker integration
* Refresh token implementation
* Frontend integration



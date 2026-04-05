# Memo API Project

A simple Memo CRUD API built with Spring Boot.  
This project demonstrates RESTful API design, validation, exception handling, and database integration.

---

## Live Demo

https://pro0313.onrender.com

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL (Render)
- Gradle
- Docker

---

## Features

- Create Memo
- Read Memo (with Pagination and Sorting)
- Update Memo
- Delete Memo
- Search Memo by keyword
- Global Exception Handling
- Unified API Response Structure

---

## API Response Format

All API responses follow this structure:

```json
{
  "success": true,
  "data": {},
  "error": null
}
```
---

## API Examples
## Get Memos (Pagination)

GET /memo?page=0&size=5&sort=id,desc

---

## Search Memos

## GET /memo?keyword=hello

Create Memo

---

## POST /memo

```json
{
  "content": "hello world"
}
```

---

## What I Learned

- Designing RESTful APIs
- Applying DTO pattern and separation of concerns
- Implementing validation and global exception handling
- Using pagination and sorting with Spring Data JPA
- Deploying a Spring Boot application using Docker
- Connecting a PostgreSQL database on Render

## Future Improvements
- Add user authentication using JWT
- Implement user-based memo management
- Improve API response structure
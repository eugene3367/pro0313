# Memo API Project

## Overview

This project is a RESTful API built with Spring Boot that provides user authentication and memo management features. It includes JWT-based authentication, structured API responses, and proper exception handling.

## Features

* User signup and login with JWT authentication
* Create, read, update, and delete memos
* Retrieve memos for the authenticated user
* Global exception handling with consistent response structure
* DTO pattern applied to separate API responses from entity models

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* JWT (JSON Web Token)

## API Structure

All API responses follow a unified format:

Success Response:
{
"success": true,
"data": {},
"error": null
}

Failure Response:
{
"success": false,
"data": null,
"error": {
"message": "Error message",
"status": 400
}
}

## Authentication

JWT is used for authentication.

After login, include the token in the Authorization header:

Authorization: Bearer {token}

## Main Endpoints

### Auth

* POST /auth/signup
* POST /auth/login
* GET /auth/users

### Memo

* POST /memo
* GET /memo
* PUT /memo/{id}
* DELETE /memo/{id}

## Project Structure

* controller: Handles HTTP requests
* service: Contains business logic
* repository: Handles database access
* entity: JPA entities
* dto: Data transfer objects
* exception: Custom exceptions and global handler
* jwt: JWT authentication logic
* response: API response wrapper

## Improvements

* Applied DTO pattern to prevent entity exposure
* Unified API response structure
* Implemented global exception handling

## Future Work

* Add pagination for memo retrieval
* Add validation for all request DTOs
* Implement refresh token logic
* Add frontend UI integration

# Memo API Project

## Overview
This project is a Spring Boot based backend application that provides memo management functionality with user authentication.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL (Render)
- JWT (JSON Web Token)

## Features

### User Authentication
- User signup
- User login
- JWT token generation

### Memo API
- Create memo
- Read memo list
- Pagination support
- Search functionality
- Sorting support

## API Endpoints

### Auth
- POST /auth/signup
- POST /auth/login

### Memo
- GET /memo
- POST /memo

## Authentication Flow
1. User logs in with username and password
2. Server validates credentials
3. JWT token is generated and returned
4. Client stores token for future requests

## Project Structure
- controller: API endpoints
- service: business logic
- repository: database access
- entity: database models
- dto: request/response objects
- jwt: token generation logic

## Database
- PostgreSQL hosted on Render

## Deployment
- Backend deployed on Render
- Database connected via environment variables

## Future Improvements
- JWT authentication filter
- Password encryption (BCrypt)
- Exception handling improvement
- API validation
- Refresh token implementation
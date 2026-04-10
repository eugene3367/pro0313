# Memo API Project

## Overview
This project is a backend API for a memo application built with Spring Boot.  
It supports user authentication using JWT and allows users to create and manage their own memos.

## Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT
- JPA (Hibernate)
- PostgreSQL

## Features

### Authentication
- User signup
- User login with JWT token

### Memo
- Create memo
- Get my memos (only authenticated user)
- Update memo
- Delete memo

## API Endpoints

### Auth
- POST /auth/signup
- POST /auth/login
- GET /auth/users

### Memo
- POST /memo
- GET /memo
- PUT /memo/{id}
- DELETE /memo/{id}

## How It Works

1. User signs up
2. User logs in and receives JWT token
3. Client sends requests with Authorization header
4. Server extracts username from token
5. Memo is saved and retrieved based on the authenticated user

## Database

- User and Memo have a relationship (ManyToOne)
- Each memo belongs to a specific user

## Notes

- All memo APIs require authentication
- JWT is used for stateless authentication
- PostgreSQL is used as the main database
# Memo API Project

간단한 메모 CRUD API 프로젝트입니다.  
Spring Boot 기반으로 REST API를 구현하고,  
DTO, Validation, Exception Handling, API 응답 구조를 적용했습니다.

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (or MySQL)
- Gradle

---

## Features

- 메모 생성 (Create)
- 메모 조회 (Read)
- 메모 수정 (Update)
- 메모 삭제 (Delete)

---

## API Structure

### Unified Response Format

모든 API 응답을 아래 구조로 통일했습니다.

```json
{
  "success": true,
  "data": {},
  "error": null
}

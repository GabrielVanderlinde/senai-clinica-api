# SENAI Clinic API

Clinical management system developed as a course project for SENAI's Java Systems Development curriculum. Demonstrates professional backend development practices using Spring Boot and modern software architecture.

## Overview

A comprehensive backend API for clinic management, built to apply theoretical knowledge from SENAI's Java Systems Development course. The system implements real-world scenarios for healthcare management operations.

## Technology Stack

- **Java** - Programming language
- **Spring Boot** - Framework
- **Spring Data JPA** - Data access layer
- **Hibernate** - ORM
- **MySQL** - Database
- **Maven** - Build automation

## Features

- Clinic management operations
- Professional API endpoints
- Data persistence
- Clean code architecture
- Error handling
- Professional documentation

## Project Structure

```
src/
├── main/
│   ├── java/com/senai/clinica/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── dto/
│   └── resources/
│       └── application.properties
└── test/
```

## Getting Started

### Prerequisites

- Java 11+
- Maven 3.6+
- MySQL 8.0+

### Installation

1. Clone the repository
```bash
git clone https://github.com/GabrielVanderlinde/senai-clinica-api.git
cd senai-clinica-api
```

2. Configure database
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost/clinica_db
spring.datasource.username=root
spring.datasource.password=root
```

3. Build and run
```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints

The API provides endpoints for clinic management operations:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/clinica` | System status |
| POST | `/api/...` | Create resources |
| GET | `/api/...` | List resources |
| PUT | `/api/...` | Update resources |
| DELETE | `/api/...` | Delete resources |

## Development Context

This project was developed during SENAI's Java Systems Development course (2026) and showcases:

- Spring Boot application development
- RESTful API design
- Database integration
- Professional code organization
- Clean architecture principles
- Real-world business logic implementation

## Learning Focus

Key concepts covered:
- Spring Boot framework
- REST API development
- Database persistence with JPA
- Professional API design
- Business logic implementation
- Error handling

## Deployment

The application runs on `http://localhost:8080` by default.

## Course Information

- Institution: SENAI
- Course: Desenvolvimento de Sistemas Java 2026
- Type: Course Project
- Status: Active

## License

MIT License - Educational purposes

## Author

Gabriel Vanderlinde - [GitHub](https://github.com/GabrielVanderlinde)

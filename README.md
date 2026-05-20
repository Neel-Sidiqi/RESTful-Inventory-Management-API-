# Inventory Management REST API

A fully functional RESTful backend service for managing inventory, built with Java and Spring Boot. This application handles CRUD operations, connects to a containerized PostgreSQL database, and includes an interactive OpenAPI (Swagger) UI for testing.

## Tech Stack
* **Language:** Java 21
* **Framework:** Spring Boot 3
* **Database:** PostgreSQL
* **Containerization:** Docker & Docker Compose
* **API Documentation:** Springdoc OpenAPI (Swagger)
* **Build Tool:** Maven

## How to Run Locally

### 1. Start the Database
Ensure Docker is running on your machine. Open a terminal in the project root directory and spin up the PostgreSQL container:
```bash
docker compose up -d
```

### 2. Run the Application
You can run the application directly from your IDE or via Maven:
```bash
./mvnw spring-boot:run
```
The server will start on `http://localhost:8080`.

## API Endpoints

Once the server is running, you can access the interactive Swagger UI at:
`http://localhost:8080/swagger-ui/index.html`

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/inventory` | Retrieve all products |
| `GET` | `/api/inventory/{id}` | Retrieve a specific product by ID |
| `POST` | `/api/inventory` | Create a new product |
| `PUT` | `/api/inventory/{id}` | Update an existing product |
| `DELETE` | `/api/inventory/{id}` | Delete a product |
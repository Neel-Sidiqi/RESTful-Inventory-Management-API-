# 📦 AI-Powered Inventory Management API

A fully functional, intelligent RESTful backend service for managing warehouse inventory. Built with Java and Spring Boot, this application handles standard CRUD operations against a containerized PostgreSQL database and features a local, privacy-first AI integration using Ollama to provide natural language querying of inventory data.

## 🚀 Features
* **Full CRUD Capabilities:** Manage products, quantities, and pricing.
* **AI-Powered Queries:** Ask natural language questions about your database (e.g., "Which items have low stock?") using a locally hosted LLaMA 3 model.
* **Data Aggregation:** Built-in Java logic to aggregate duplicate product listings before AI processing to ensure mathematical accuracy and reduce token usage.
* **Containerized Database:** Zero-config PostgreSQL setup using Docker Compose.
* **Interactive Documentation:** Built-in Swagger UI for instant endpoint testing.

## 🛠️ Tech Stack
* **Language:** Java 21
* **Framework:** Spring Boot 3
* **Database:** PostgreSQL
* **AI Integration:** Ollama (Llama 3 8B)
* **Containerization:** Docker & Docker Compose
* **API Documentation:** Springdoc OpenAPI (Swagger)

## ⚙️ Prerequisites
Before running the application, ensure you have the following installed:
* [Docker Desktop](https://www.docker.com/products/docker-desktop)
* [Ollama](https://ollama.com/)
* Java 21 & Maven

## 🏃‍♂️ How to Run Locally

### 1. Start the Database
Ensure Docker is running on your machine. Open a terminal in the project root directory and spin up the PostgreSQL container:
```bash
docker compose up -d
```

### 2. Start the Local AI
Ensure Ollama is installed and running on your machine. Pull and run the `llama3` model (this runs on `localhost:11434` by default):
```bash
ollama run llama3
```

### 3. Run the Application
You can run the application directly from your IDE or via Maven:
```bash
./mvnw spring-boot:run
```
The server will start on `http://localhost:8080`.

## 📡 API Endpoints

Once the server is running, you can access the interactive Swagger UI at:
👉 `http://localhost:8080/swagger-ui/index.html`

### Inventory Management
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/inventory` | Retrieve all products |
| `GET` | `/api/inventory/{id}` | Retrieve a specific product by ID |
| `POST` | `/api/inventory` | Create a new product |
| `PUT` | `/api/inventory/{id}` | Update an existing product |
| `DELETE` | `/api/inventory/{id}` | Delete a product |

### AI Assistant
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/ai/query` | Ask natural language questions about the current inventory |

**Example AI Request (`POST /api/ai/query`):**
```json
{
  "question": "Which products have fewer than 10 units in stock?"
}
```
# tasklist-spring

**Description:**  
This repo is used for learning Java and Spring Boot. 

This app has auth endpoints (`/auth/login`, `/auth/register`) and (`/healthCheck`). Uses PostgreSQL.
Tasklist coming soon.

![Last Commit](https://img.shields.io/github/last-commit/Jozefwl/tasklist?style=for-the-badge)
![Java Version](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-darkgreen?style=for-the-badge&logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-black?style=for-the-badge&logo=postgresql)

## Endpoints:

### **1. Authentication:**

#### `POST /auth/register`
Registers a new user.

- **Request Body:**
```json
{
  "username": "newUser",
  "password": "userPassword"
}
```

- **Response:**
```json
{
  "message": "User registered successfully!"
}
```

#### `POST /auth/login`
Logs in a user and returns a mock token.

- **Request Body:**
```json
{
  "username": "existingUser",
  "password": "userPassword"
}
```

- **Response:**
```json
{
  "message": "Login successful!",
  "token": "megaplaceholder-1234-abcd-5678-efgh"
}
```

### **2. Health Check:**

#### `GET /healthCheck`
Simple response.

- **Response:**
```json
{
  "status": "Spring running"
}
```
TODO: add some more cool stuff.

### Note:
Tasklist is todo as i am having a hard time with importing JWT dependencies

---

**How to Run:**

1. Clone the repo:
```bash
git clone <repo-url>
```

2. Navigate to the project folder and run:
```bash
cd tasklist-spring && gradlew bootRun
```

3. Call REST API @ `http://localhost:8080/xxx`.

---

**Disclaimer:** Obviously use ENV variables, plaintext is for dev purposes only.

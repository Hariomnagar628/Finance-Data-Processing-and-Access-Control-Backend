
# Finance-Data-Processing-and-Access-Control-Backend
This project is a Finance Data Processing Backend built using Spring Boot and MySQL.

# 💰 Finance Data Processing and Access Control Backend

## 📌 Project Overview

This project is a backend system designed for a finance dashboard application. It enables users to manage financial records such as income and expenses while enforcing role-based access control.

The system is built with a focus on clean architecture, proper API design, and maintainable backend logic. It simulates a real-world backend environment where different users interact with data based on their assigned roles.

---

## 🚀 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **MySQL**
* **Postman** (for API testing)

---

## 🧩 Key Features

### 👤 User & Role Management

* Create and manage users
* Assign roles: **ADMIN, ANALYST, VIEWER**
* Manage user status (active/inactive)
* Enforce role-based access restrictions

---

### 💰 Financial Records Management

* Create financial records (income/expense)
* Store details such as:

    * Amount
    * Type (INCOME / EXPENSE)
    * Category
    * Date
    * Description
* Persist data using MySQL database

---

### 📊 Dashboard Summary APIs

* Total Income calculation
* Total Expense calculation
* Net Balance calculation

These APIs demonstrate backend aggregation logic beyond basic CRUD operations.

---

### 🔐 Access Control Logic

* **ADMIN**

    * Full access (create users, manage records)
* **ANALYST**

    * View financial records and dashboard insights
* **VIEWER**

    * Read-only access to dashboard

> Note: Role-based access is implemented using request headers for demonstration purposes. In production, this can be replaced with JWT authentication.

---

## 📂 Project Structure

```
financebackend
│
├── controller
├── service
├── repository
├── model
├── config
└── FinancebackendApplication.java
```

---

## 🔗 API Endpoints

### 👤 User APIs

* `POST /users` → Create user (**ADMIN only**)
* `GET /users` → Get all users

---

### 💰 Financial Record APIs

* `POST /records` → Create financial record (**ADMIN only**)

---

### 📊 Dashboard APIs

* `GET /dashboard/summary` → Get financial summary (**All roles**)

---

## 🧪 API Testing (Postman)

### 📌 Add Header for Role-Based Access

```
Key: role
Value: ADMIN / ANALYST / VIEWER
```

---

### 📌 Example Request

**POST /records**

```json
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-02",
  "description": "Monthly salary"
}
```

---

## 🗄️ Database Configuration

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run the Project

1. Clone the repository
2. Create MySQL database:

   ```
   CREATE DATABASE finance_db;
   ```
3. Configure database credentials in `application.properties`
4. Run the Spring Boot application
5. Use Postman to test APIs

---

## ⚠️ Assumptions & Notes

* Role-based access is simulated using request headers
* Authentication (JWT) is not implemented due to scope limitations
* Focus is on backend design, logic, and API structure

---

## 🌟 Future Enhancements

* JWT Authentication & Authorization
* Pagination and filtering for records
* Swagger/OpenAPI documentation
* Category-wise analytics
* Monthly/weekly trend analysis
* Unit and integration testing

---

## 🧠 Conclusion

This project demonstrates backend development skills including API design, data modeling, role-based access control, and financial data processing. It reflects a structured approach to building scalable and maintainable backend systems.

---

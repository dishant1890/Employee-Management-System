# Employee Management System

## Project Description
The Employee Management System is a backend application developed using **Java and Spring Boot**
to manage employees and departments with **role-based access control** and secure REST APIs.
---
## Features
- Role-based authentication and authorization (**ADMIN, HR**)
- CRUD operations for employees and departments
- Secure REST APIs using **Spring Security**
- MySQL database integration
- Password encryption using **BCrypt**
- Clean layered architecture (Controller, Service, Repository)
---
## User Roles & Access
- **ADMIN**
  - Full access to employee and department management
  - Can create, update, delete, and view all records

- **HR**
  - Can manage employee records
  - Has limited access compared to ADMIN
---
## Authentication & Demo Credentials
- User authentication is implemented using **Spring Security**
- Passwords are encrypted using **BCryptPasswordEncoder**
- Plain text passwords are never stored in the database

### Demo Login Credentials (For Testing Purpose Only)
- **ADMIN**
  - Username: admin
  - Password: admin123

- **HR**
  - Username: hr
  - Password: hr123
---
## Tech Stack
- Java  
- Spring Boot  
- Spring Data JPA  
- Spring Security  
- MySQL  
- Maven  
---
## API Access Rules
- `/departments/**` → ADMIN only  
- `/employees/**` → ADMIN & HR  
---
## How to Run the Project
1. Clone the repository
2. 2. Create a MySQL database and update credentials in application.properties  
3. Run the application using your IDE  
   or execute

## Future Enhancements
- JWT-based authentication
- Docker support
- Frontend integration (React / Angular)
- Cloud deployment (AWS / Render)
---
## Author
**Dishant Thakur**  
BCA Student | Java & Spring Boot Developer
3. Create a MySQL database and update credentials in `application.properties`  
4. Run the application using your IDE  
   or execute:

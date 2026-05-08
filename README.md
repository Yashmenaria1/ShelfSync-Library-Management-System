![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.7.0-brightgreen)
![React](https://img.shields.io/badge/React-18.2.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.0-red)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18.3-blue)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Tomcat](https://img.shields.io/badge/Tomcat-10.1.20-yellow)

**ShelfSync-Library Management System**
---
ShelfSync is a scalable full-stack Library Management System developed with Spring Boot and React.js, designed to streamline library operations. It supports book cataloging, member management, borrow/return workflows, and fast search functionality with a responsive user interface.
---
## Features
- Add, update, delete books
- Borrow and return books
- Search for books by title, author, or category
- Manage authors and categories
- User-friendly frontend built with React
- RESTful API backend with Spring Boot
---

## Project Structure
```markdown
ShelfSync-Library-Management-System/
│
├── backend/                                  # Spring Boot Backend
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── shelfsync/
│   │   │   │
│   │   │   │           ├── ShelfSyncApplication.java
│   │   │   │
│   │   │   │           ├── config/                  # Configuration Classes
│   │   │   │           │   ├── SwaggerConfig.java
│   │   │   │           │   ├── RedisConfig.java
│   │   │   │           │   ├── AppConfig.java
│   │   │   │           │   ├── ModelMapperConfig.java
│   │   │   │           │   └── CorsConfig.java
│   │   │   │
│   │   │   │           ├── controller/              # REST Controllers
│   │   │   │           │   ├── AuthController.java
│   │   │   │           │   ├── UserController.java
│   │   │   │           │   ├── BookController.java
│   │   │   │           │   ├── CategoryController.java
│   │   │   │           │   ├── BorrowController.java
│   │   │   │           │   ├── FineController.java
│   │   │   │           │   ├── NotificationController.java
│   │   │   │           │   └── AdminController.java
│   │   │   │
│   │   │   │           ├── service/                 # Service Interfaces
│   │   │   │           │   ├── AuthService.java
│   │   │   │           │   ├── UserService.java
│   │   │   │           │   ├── BookService.java
│   │   │   │           │   ├── CategoryService.java
│   │   │   │           │   ├── BorrowService.java
│   │   │   │           │   ├── FineService.java
│   │   │   │           │   ├── EmailService.java
│   │   │   │           │   ├── RedisCacheService.java
│   │   │   │           │   └── NotificationService.java
│   │   │   │
│   │   │   │           ├── service/impl/            # Service Implementations
│   │   │   │           │   ├── AuthServiceImpl.java
│   │   │   │           │   ├── UserServiceImpl.java
│   │   │   │           │   ├── BookServiceImpl.java
│   │   │   │           │   ├── CategoryServiceImpl.java
│   │   │   │           │   ├── BorrowServiceImpl.java
│   │   │   │           │   ├── FineServiceImpl.java
│   │   │   │           │   ├── EmailServiceImpl.java
│   │   │   │           │   ├── RedisCacheServiceImpl.java
│   │   │   │           │   └── NotificationServiceImpl.java
│   │   │   │
│   │   │   │           ├── repository/              # JPA Repositories
│   │   │   │           │   ├── UserRepository.java
│   │   │   │           │   ├── RoleRepository.java
│   │   │   │           │   ├── BookRepository.java
│   │   │   │           │   ├── CategoryRepository.java
│   │   │   │           │   ├── BorrowRepository.java
│   │   │   │           │   ├── FineRepository.java
│   │   │   │           │   └── NotificationRepository.java
│   │   │   │
│   │   │   │           ├── entity/                  # Database Entities
│   │   │   │           │   ├── BaseEntity.java
│   │   │   │           │   ├── User.java
│   │   │   │           │   ├── Role.java
│   │   │   │           │   ├── Book.java
│   │   │   │           │   ├── Category.java
│   │   │   │           │   ├── BorrowRecord.java
│   │   │   │           │   ├── Fine.java
│   │   │   │           │   └── Notification.java
│   │   │   │
│   │   │   │           ├── dto/
│   │   │   │           │   ├── request/             # Request DTOs
│   │   │   │           │   │   ├── LoginRequest.java
│   │   │   │           │   │   ├── RegisterRequest.java
│   │   │   │           │   │   ├── BookRequest.java
│   │   │   │           │   │   ├── BorrowRequest.java
│   │   │   │           │   │   └── FineRequest.java
│   │   │   │           │   │
│   │   │   │           │   └── response/            # Response DTOs
│   │   │   │           │       ├── JwtResponse.java
│   │   │   │           │       ├── ApiResponse.java
│   │   │   │           │       ├── BookResponse.java
│   │   │   │           │       ├── UserResponse.java
│   │   │   │           │       └── BorrowResponse.java
│   │   │   │
│   │   │   │           ├── security/
│   │   │   │           │   ├── config/
│   │   │   │           │   │   └── SecurityConfig.java
│   │   │   │           │   │
│   │   │   │           │   ├── jwt/
│   │   │   │           │   │   ├── JwtAuthenticationFilter.java
│   │   │   │           │   │   ├── JwtService.java
│   │   │   │           │   │   ├── JwtAuthenticationEntryPoint.java
│   │   │   │           │   │   └── JwtTokenProvider.java
│   │   │   │           │   │
│   │   │   │           │   └── service/
│   │   │   │           │       └── CustomUserDetailsService.java
│   │   │   │
│   │   │   │           ├── exception/
│   │   │   │           │   ├── GlobalExceptionHandler.java
│   │   │   │           │   ├── ResourceNotFoundException.java
│   │   │   │           │   ├── DuplicateResourceException.java
│   │   │   │           │   ├── UnauthorizedException.java
│   │   │   │           │   ├── InvalidRequestException.java
│   │   │   │           │   └── TokenExpiredException.java
│   │   │   │
│   │   │   │           ├── validation/
│   │   │   │           │   ├── PasswordValidator.java
│   │   │   │           │   └── EmailValidator.java
│   │   │   │
│   │   │   │           ├── mapper/
│   │   │   │           │   └── EntityMapper.java
│   │   │   │
│   │   │   │           ├── util/
│   │   │   │           │   ├── AppConstants.java
│   │   │   │           │   ├── DateUtil.java
│   │   │   │           │   ├── JwtUtil.java
│   │   │   │           │   └── PaginationUtil.java
│   │   │   │
│   │   │   │           ├── scheduler/
│   │   │   │           │   ├── FineScheduler.java
│   │   │   │           │   └── NotificationScheduler.java
│   │   │   │
│   │   │   │           ├── logging/
│   │   │   │           │   └── LoggingAspect.java
│   │   │   │
│   │   │   │           ├── aspect/
│   │   │   │           │   ├── PerformanceTrackingAspect.java
│   │   │   │           │   └── LoggingAspect.java
│   │   │   │
│   │   │   │           ├── cache/
│   │   │   │           │   └── RedisCacheManager.java
│   │   │   │
│   │   │   │           └── enums/
│   │   │   │               ├── RoleType.java
│   │   │   │               ├── BookStatus.java
│   │   │   │               └── NotificationType.java
│   │   │   │
│   │   │   └── resources/
│   │   │       ├── application.yml
│   │   │       ├── application-dev.yml
│   │   │       ├── application-prod.yml
│   │   │       ├── data.sql
│   │   │       ├── schema.sql
│   │   │       ├── static/
│   │   │       └── templates/
│   │   │
│   │   └── test/
│   │       └── java/com/shelfsync/
│   │           ├── controller/
│   │           ├── service/
│   │           ├── repository/
│   │           └── security/
│   │
│   ├── docker/
│   │   ├── Dockerfile
│   │   ├── docker-compose.yml
│   │   └── redis.conf
│   │
│   ├── logs/
│   │   └── application.log
│   │
│   ├── .env
│   ├── .gitignore
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── README.md
│
├── frontend/                                 # React Frontend
│   │
│   ├── public/
│   │   ├── favicon.ico
│   │   ├── index.html
│   │   └── manifest.json
│   │
│   ├── src/
│   │   ├── api/
│   │   │   ├── authApi.js
│   │   │   ├── bookApi.js
│   │   │   ├── borrowApi.js
│   │   │   └── axiosConfig.js
│   │   │
│   │   ├── assets/
│   │   │   ├── images/
│   │   │   ├── icons/
│   │   │   └── styles/
│   │   │
│   │   ├── components/
│   │   │   ├── common/
│   │   │   ├── auth/
│   │   │   ├── books/
│   │   │   ├── borrow/
│   │   │   ├── dashboard/
│   │   │   └── layout/
│   │   │
│   │   ├── context/
│   │   │   └── AuthContext.jsx
│   │   │
│   │   ├── hooks/
│   │   │   └── useAuth.js
│   │   │
│   │   ├── pages/
│   │   │   ├── LoginPage.jsx
│   │   │   ├── RegisterPage.jsx
│   │   │   ├── DashboardPage.jsx
│   │   │   ├── BooksPage.jsx
│   │   │   ├── BorrowPage.jsx
│   │   │   └── AdminPage.jsx
│   │   │
│   │   ├── routes/
│   │   │   ├── AppRoutes.jsx
│   │   │   └── ProtectedRoute.jsx
│   │   │
│   │   ├── services/
│   │   │   ├── authService.js
│   │   │   ├── bookService.js
│   │   │   └── borrowService.js
│   │   │
│   │   ├── utils/
│   │   │   ├── tokenUtils.js
│   │   │   └── constants.js
│   │   │
│   │   ├── App.jsx
│   │   ├── main.jsx
│   │   └── index.css
│   │
│   ├── .env
│   ├── .gitignore
│   ├── package.json
│   ├── vite.config.js
│   └── README.md
│
├── docs/                                     # Project Documentation
│   ├── API_DOCUMENTATION.md
│   ├── DATABASE_SCHEMA.md
│   ├── SECURITY_FLOW.md
│   ├── DEPLOYMENT_GUIDE.md
│   └── PROJECT_ARCHITECTURE.md
│
├── postman/
│   └── ShelfSync_API_Collection.json
│
├── .gitignore
├── LICENSE
├── README.md
└── docker-compose.yml
```
## Installation

### 1. Clone the Repository
```bash
git clone https://github.com/Yashmenaria1/ShelfSync-Library-Management-System.git
cd ShelfSync-Library-Management-System
```

### 2. Backend (Spring Boot)

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### 3. Frontend (React)

```bash
cd frontend
npm install
npm start
```

The frontend will run on `http://localhost:3000` and connect to the backend API.

---

## Technologies Used

* **Backend:** Java, Spring Boot, Spring Data JPA, MVC, Microservices, PostgreSQL
* **Frontend:** React.js, Bootstrap
* **Version Control:** Git & GitHub
* **Build Tools:** Maven, npm, Tomcat

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Author

**Yash Menaria** – [GitHub Profile](https://github.com/Yashmenaria1)

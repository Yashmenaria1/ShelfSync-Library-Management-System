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

The current codebase in this repository represents a basic LMS backend implementation built using Spring Boot with layered architecture, RESTful APIs, JPA/Hibernate integration, and PostgreSQL database support. I am currently working on the advanced enterprise-level version of ShelfSync with enhanced architecture, security, scalability, and additional production-grade features. Once completed, the full enterprise edition of ShelfSync will be moved to a separate dedicated GitHub repository.

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
│   │   │   │           │   ├── AuthorController.java
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
│   │   │   │           │   ├── AuthorService.java
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
│   │   │   │           │   ├── AuthorServiceImpl.java
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
│   │   │   │           │   ├── AuthorRepository.java
│   │   │   │           │   ├── BorrowRepository.java
│   │   │   │           │   ├── FineRepository.java
│   │   │   │           │   └── NotificationRepository.java
│   │   │   │
│   │   │   │           ├── entity/                  # Database Entities
│   │   │   │           │   ├── BaseEntity.java
│   │   │   │           │   ├── User.java
│   │   │   │           │   ├── Role.java
│   │   │   │           │   ├── Author.java
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
│   │   │   │           │   │   ├── JwtUtil.java
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
│   │   │   │           │   └── PaginationUtil.java
│   │   │   │
│   │   │   │           ├── scheduler/
│   │   │   │           │   ├── FineScheduler.java
│   │   │   │           │   └── NotificationScheduler.java
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
├── frontend/                                 # React + Vite Frontend
│   │
│   ├── public/
│   │   ├── favicon.ico
│   │   ├── manifest.json
│   │   ├── robots.txt
│   │   ├── logo.png
│   │   └── index.html
│   │
│   ├── src/
│   │
│   │   ├── app/                              # Application Entry
│   │   │   ├── App.jsx
│   │   │   ├── main.jsx
│   │   │   ├── router.jsx
│   │   │   ├── providers.jsx
│   │   │   └── queryClient.js
│   │   │
│   │   ├── assets/
│   │   │
│   │   │   ├── images/
│   │   │   ├── icons/
│   │   │   ├── fonts/
│   │   │   ├── illustrations/
│   │   │   └── styles/
│   │   │       ├── globals.css
│   │   │       ├── variables.css
│   │   │       ├── animations.css
│   │   │       ├── scrollbar.css
│   │   │       └── theme.css
│   │   │
│   │   ├── components/
│   │   │
│   │   │   ├── ui/
│   │   │   │
│   │   │   │   ├── Button.jsx
│   │   │   │   ├── Input.jsx
│   │   │   │   ├── TextArea.jsx
│   │   │   │   ├── Select.jsx
│   │   │   │   ├── Checkbox.jsx
│   │   │   │   ├── Radio.jsx
│   │   │   │   ├── Badge.jsx
│   │   │   │   ├── Avatar.jsx
│   │   │   │   ├── Card.jsx
│   │   │   │   ├── Modal.jsx
│   │   │   │   ├── Drawer.jsx
│   │   │   │   ├── Table.jsx
│   │   │   │   ├── Pagination.jsx
│   │   │   │   ├── Tooltip.jsx
│   │   │   │   ├── Tabs.jsx
│   │   │   │   ├── Spinner.jsx
│   │   │   │   ├── Skeleton.jsx
│   │   │   │   ├── SearchBar.jsx
│   │   │   │   ├── ConfirmDialog.jsx
│   │   │   │   ├── Breadcrumb.jsx
│   │   │   │   └── DataTable.jsx
│   │   │   │
│   │   │   ├── layout/
│   │   │   │   ├── Navbar.jsx
│   │   │   │   ├── Sidebar.jsx
│   │   │   │   ├── Footer.jsx
│   │   │   │   ├── DashboardLayout.jsx
│   │   │   │   ├── AuthLayout.jsx
│   │   │   │   ├── AdminLayout.jsx
│   │   │   │   └── PageContainer.jsx
│   │   │   │
│   │   │   ├── common/
│   │   │   │   ├── Loader.jsx
│   │   │   │   ├── EmptyState.jsx
│   │   │   │   ├── ErrorBoundary.jsx
│   │   │   │   ├── NoData.jsx
│   │   │   │   ├── Unauthorized.jsx
│   │   │   │   ├── PageHeader.jsx
│   │   │   │   └── PageTitle.jsx
│   │   │   │
│   │   │   └── charts/
│   │   │       ├── BorrowChart.jsx
│   │   │       ├── FineChart.jsx
│   │   │       ├── CategoryChart.jsx
│   │   │       ├── UserChart.jsx
│   │   │       └── DashboardChart.jsx
│   │   │
│   │   ├── features/
│   │   │
│   │   │   ├── auth/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── hooks/
│   │   │   │   ├── pages/
│   │   │   │   ├── services/
│   │   │   │   ├── validation/
│   │   │   │   └── authStore.js
│   │   │   │
│   │   │   ├── dashboard/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   └── services/
│   │   │   │
│   │   │   ├── users/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   ├── services/
│   │   │   │   ├── hooks/
│   │   │   │   └── validation/
│   │   │   │
│   │   │   ├── books/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   ├── services/
│   │   │   │   ├── hooks/
│   │   │   │   └── validation/
│   │   │   │
│   │   │   ├── authors/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   ├── services/
│   │   │   │   └── validation/
│   │   │   │
│   │   │   ├── categories/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   ├── services/
│   │   │   │   └── validation/
│   │   │   │
│   │   │   ├── borrow/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   ├── services/
│   │   │   │   ├── hooks/
│   │   │   │   └── validation/
│   │   │   │
│   │   │   ├── fines/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   └── services/
│   │   │   │
│   │   │   ├── notifications/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   └── services/
│   │   │   │
│   │   │   ├── reports/
│   │   │   │   ├── api/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   └── services/
│   │   │   │
│   │   │   ├── profile/
│   │   │   │   ├── components/
│   │   │   │   ├── pages/
│   │   │   │   └── services/
│   │   │   │
│   │   │   └── settings/
│   │   │       ├── components/
│   │   │       ├── pages/
│   │   │       └── services/
│   │   │
│   │   ├── hooks/
│   │   │   ├── useAuth.js
│   │   │   ├── usePagination.js
│   │   │   ├── useSearch.js
│   │   │   ├── useDebounce.js
│   │   │   ├── useModal.js
│   │   │   ├── useLocalStorage.js
│   │   │   └── useTheme.js
│   │   │
│   │   ├── context/
│   │   │   ├── AuthProvider.jsx
│   │   │   ├── ThemeProvider.jsx
│   │   │   └── NotificationProvider.jsx
│   │   │
│   │   ├── services/
│   │   │   ├── axiosClient.js
│   │   │   ├── interceptor.js
│   │   │   ├── tokenService.js
│   │   │   ├── storageService.js
│   │   │   └── fileUploadService.js
│   │   │
│   │   ├── routes/
│   │   │   ├── AppRoutes.jsx
│   │   │   ├── ProtectedRoute.jsx
│   │   │   ├── AdminRoute.jsx
│   │   │   ├── GuestRoute.jsx
│   │   │   └── RoleBasedRoute.jsx
│   │   │
│   │   ├── store/
│   │   │   ├── authStore.js
│   │   │   ├── dashboardStore.js
│   │   │   ├── bookStore.js
│   │   │   ├── borrowStore.js
│   │   │   ├── notificationStore.js
│   │   │   └── themeStore.js
│   │   │
│   │   ├── utils/
│   │   │   ├── constants.js
│   │   │   ├── permissions.js
│   │   │   ├── validators.js
│   │   │   ├── dateUtils.js
│   │   │   ├── pagination.js
│   │   │   ├── helper.js
│   │   │   └── exportUtils.js
│   │   │
│   │   ├── config/
│   │   │   ├── env.js
│   │   │   ├── routes.js
│   │   │   ├── sidebar.js
│   │   │   ├── roles.js
│   │   │   └── menu.js
│   │   │
│   │   ├── types/
│   │   │   └── api.types.js
│   │   │
│   │   └── index.css
│   │
│   ├── .env
│   ├── .env.development
│   ├── .env.production
│   ├── .eslint.config.js
│   ├── .prettierrc
│   ├── jsconfig.json
│   ├── package.json
│   ├── vite.config.js
│   └── README.md
│
├── docs/
│   ├── API_DOCUMENTATION.md
│   ├── DATABASE_SCHEMA.md
│   ├── SECURITY_FLOW.md
│   ├── DEPLOYMENT_GUIDE.md
│   └── PROJECT_ARCHITECTURE.md
│
├── postman/
│   └── ShelfSync_API_Collection.json
│
├── .github/
│   ├── workflows/
│   │   ├── backend-ci.yml
│   │   ├── frontend-ci.yml
│   │   └── deploy.yml
│   │
│   ├── ISSUE_TEMPLATE/
│   └── PULL_REQUEST_TEMPLATE.md
│
├── scripts/
│   ├── setup.sh
│   ├── setup.bat
│   └── deploy.sh
│
├── .editorconfig
├── .gitignore
├── docker-compose.yml
├── LICENSE
└── README.md
```
---

## Backend Flow
```markdown

React Frontend
        ↓
CORS allows request
        ↓
Controller receives request
        ↓
DTO mapped using ModelMapper
        ↓
Service processes logic
        ↓
Repository accesses PostgreSQL
        ↓
Redis caches result
        ↓
Swagger documents endpoint
        ↓
Logs generated
```
---

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

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.7.0-brightgreen)
![React](https://img.shields.io/badge/React-18.2.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.0-red)
![Node](https://img.shields.io/badge/Node-18.17.0-green)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

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

LibraryManagement/
├── backend/ # Spring Boot backend
│ ├── src/
│ ├── pom.xml
│ └── mvnw
├── frontend/ # React frontend
│ ├── src/
│ ├── public/
│ └── package.json
├── README.md
└── .gitignore
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
* **Build Tools:** Maven, npm

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Author

**Yash Menaria** – [GitHub Profile]([https://github.com/Yashmenaria1])

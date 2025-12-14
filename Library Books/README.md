## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).



Project Title: Library Books Management System
Students:
- Full Name 1 – system sylvere Barinda Reg No 24RP08563
- Full Name 2 – Thiery aime Byiringiro Reg No 24RP07221
- Full Name 3 – Fubrice Mujyema  Reg No 24RP01072
- Full Name 4 – Kellia Kayitare Berwa  Reg No 24RP12380


Description:
A Java Swing desktop application for managing library books using JDBC and OOP principles.


Features:
- Add, View, Update, Delete books
- RegEx validation
- JTable display


How to Run:
- Import project
- Configure JDBC
- Run LibraryUI


# 📚 Library Books Management System

## 📌 Project Overview

The **Library Books Management System** is a desktop-based application developed using **Java Swing** and **MySQL**. It is designed to help libraries manage books efficiently by providing features such as adding, updating, deleting, and viewing books, as well as monitoring statistics through a dashboard.

This project was developed as part of an academic assignment and follows **professional software development standards**, including proper architecture, validation, and database integration.

---

## 🎯 Objectives

* Manage library books efficiently
* Practice **CRUD operations** using Java and MySQL
* Apply **Object-Oriented Programming (OOP)** principles
* Build a **professional graphical user interface (GUI)** using Java Swing
* Demonstrate understanding of **JDBC database connectivity**

---

## 🛠️ Technologies Used

* **Programming Language:** Java (JDK 8+)
* **GUI Framework:** Java Swing
* **Database:** MySQL
* **Database Connectivity:** JDBC (MySQL Connector/J)
* **IDE:** Visual Studio Code
* **Version Control:** Git & GitHub

---

## 🗂️ Project Structure

```
src/
├── ui/
│   ├── MainFrame.java
│   ├── DashboardPanel.java
│   ├── BookPanel.java
│   ├── CategoryPanel.java
│   └── BookFormDialog.java
│
├── model/
│   └── Book.java
│
├── service/
│   └── BookService.java
│
├── db/
│   └── DBConnection.java
│
lib/
└── mysql-connector-j-8.x.x.jar
```

---

## ✨ Features

### 📘 Book Management (CRUD)

* Add new books
* Update existing book details
* Delete books
* View all books in a table
* Auto-incremented Book ID (handled by MySQL)

### 📊 Dashboard

* Displays total number of books
* Displays total number of authors
* Displays total number of categories
* Displays number of available books
* Uses colored cards for a professional look

### 🗂️ Category Module

* Displays all book categories
* Shows number of books per category

### 🔐 Validation

* Title: Letters and numbers only
* Author: Letters only
* ISBN: 10–13 digits
* Category: Optional, letters only

---

## 🧩 Database Design

### Database Name

```
library_books_management_system
```

### Table: `books`

```sql
CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    category VARCHAR(100),
    status VARCHAR(20) NOT NULL
);
```

---

## ⚙️ How to Run the Project

### 1️⃣ Prerequisites

* Java JDK 8 or higher installed
* MySQL Server installed and running
* Visual Studio Code installed
* MySQL Connector/J downloaded

### 2️⃣ Database Setup

1. Open MySQL
2. Create the database:

```sql
CREATE DATABASE library_books_management_system;
```

3. Create the `books` table using the SQL provided above

### 3️⃣ Configure MySQL Connection

Edit `DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/library_books_management_system";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 4️⃣ Add MySQL Connector

* Place `mysql-connector-j-8.x.x.jar` inside the `lib/` folder
* Add it to the classpath in VS Code

### 5️⃣ Run the Application

Run the main class:

```
MainFrame.java
```

---

## 🧠 Programming Concepts Applied

* Object-Oriented Programming (Encapsulation, Abstraction)
* MVC-like architecture
* JDBC PreparedStatements
* Input validation using Regular Expressions
* Exception handling
* Auto-increment primary keys

---

## 📸 Screenshots

* Dashboard view
* Book management page
* Category page


## 📦 Git Commit

Final project commit message used:

```
Complete Library Books Management System with dashboard and category modules
```

---

## 👨‍🎓 Developer

**Name:** Barinda System Sylvere
**Name:** Thiery aime Byiringiro
**Name:** Fubrice Mujyema
**Name:** Kellia Kayitare Berwa
**Course:**  OOP USING JAVA
**Project Type:** Academic Assignment

---

## ✅ Conclusion

This project successfully demonstrates the implementation of a **Library Books Management System** using Java Swing and MySQL. It follows professional coding practices and fulfills all the requirements of the assignment, including GUI design, database interaction, and functional completeness.

---

Thank you 🙏

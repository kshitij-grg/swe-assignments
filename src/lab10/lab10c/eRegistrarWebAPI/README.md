# 📚 eRegistrar Web API

A **Spring Boot RESTful Web API** for managing student registrations in a university system.  
Features include creating, retrieving, updating, and deleting student records, with proper exception handling.

---

## 🚀 API Endpoints Demonstration (via Postman)

### 1️⃣ Creating a Student
**POST** `/eregistrar/api/student/register`  
![POST - 1.png](screenshots/POST%20-%201.png)  
![POST - 2.png](screenshots/POST%20-%202.png)  
![POST - 3.png](screenshots/POST%20-%203.png)

---

### 2️⃣ Getting the Student List
**GET** `/eregistrar/api/student/list`  
![GET.png](screenshots/GET.png)

---

### 3️⃣ Getting a Single Student
**GET** `/eregistrar/api/student/get/{id}`  
![GET SINGLE.png](screenshots/GET%20SINGLE.png)

---

### 4️⃣ Updating a Student
**PUT** `/eregistrar/api/student/update/{id}`  
![PUT.png](screenshots/PUT.png)

---

### 5️⃣ Deleting a Student
**DELETE** `/eregistrar/api/student/delete/{id}`  
![DELETE.png](screenshots/DELETE.png)

---

### 6️⃣ Getting After Deletion
**GET** `/eregistrar/api/student/list` *(after deletion)*  
![GET after DELETE.png](screenshots/GET%20after%20DELETE.png)

---

### ⚠ Exception Handling
Example of API returning **404 Not Found** when student does not exist.  
![EXCEPTION.png](screenshots/EXCEPTION.png)

---

## 💡 Tech Stack
- Java 17+
- Spring Boot (Web, Data JPA)
- MySQL Database
- Postman for API testing

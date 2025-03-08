# 🛒 Microservices-Based E-Commerce System  

## 🚀 Overview  
This project is a **microservices-based e-commerce system** built using **Spring Boot, MySQL, and Eureka**. It follows the **microservices architecture** to ensure **scalability, maintainability, and modularity**.  

## 🛠️ Tech Stack  
- **Spring Boot** - Backend services  
- **Eureka Server** - Service discovery  
- **MySQL** - Relational database  
- **REST APIs** - Communication between services  

## 📌 Features  
### 🔹 Product Service  
- Stores product details:  
  - `id` (Primary Key)  
  - `product_name`  
  - `price`  
- Exposes REST APIs to manage product data  

### 🔹 Order Service  
- Stores order details:  
  - `id` (Primary Key)  
  - `product_id` (Foreign Key)  
  - `quantity`  
- Dynamically calculates total price when an API request is made  

### 🔹 Eureka Server  
- Manages service discovery  
- Ensures seamless inter-service communication  

## 🎯 Future Enhancements  
- ✅ Implement **OAuth** for authentication & authorization  
- ✅ Introduce **Cart Service** to allow users to add multiple products  
- ✅ Enhance **API security** and implement rate limiting  

## 🚀 How to Run  
### 1️⃣ Clone the Repository  
```sh
git clone https://github.com/VishalKmk/MicroSerives/
cd MicroServices

# FoodShare
“FoodShare is a web application that helps reduce food waste by connecting people who have leftover food with those in need nearby.”

<img width="1847" height="867" alt="Image" src="https://github.com/user-attachments/assets/ebc4d562-f056-4b9b-9c26-fafafce3ce2b" />


✨ Features ----

Share leftover food with nearby people
Browse available food items
Contact the food provider
Simple and clean UI
Fully responsive frontend
Backend APIs built with Spring Boot
MySQL database for storing users + listings

🛠️ Tech Stack

Frontend:
HTML
CSS
JavaScript
Bootstrap

Backend:
Java
Spring Boot
Spring Web
Spring Data JPA

Database:
MySQL

🚀 How to Run the Project Locally

1️⃣ Clone the Repository
git clone https://github.com/sonaligupta08/FoodShare.git
cd FoodShare

2️⃣ Start the Backend (Spring Boot)
Update MySQL Configuration
Edit application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/foodshare
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update

▶️ Run the backend
mvn spring-boot:run

Your backend will start at:
👉 http://localhost:8080

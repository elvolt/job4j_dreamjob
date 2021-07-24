[![Build Status](https://travis-ci.com/elvolt/job4j_dreamjob.svg?branch=master)](https://travis-ci.com/elvolt/job4j_dreamjob)
[![codecov](https://codecov.io/gh/elvolt/job4j_dreamjob/branch/master/graph/badge.svg?token=VHRJ3N8S46)](https://codecov.io/gh/elvolt/job4j_dreamjob)

# Dream Job

## О проекте
Площадка для размещения вакансий и кандидатов.

### Функционал
- CRUD операции с PostgreSQL и JDBC для вакансий и кандидатов.
- Авторизация/регистрация. Учётные данные хранятся в БД. Без авторизации
ограничен доступ к некоторым страницам.

### Используемые технологии
- Servlet/JSP
- JDBC/PostgreSQL
- Maven
- Apache Tomcat
- JUnit/Mockito
- Slf4j
- Travis
- JS, AJAX, JSP, HTML (front)
- архитектурный паттерн MVC

### Демо
Страница регистрации
![ScreenShot](images/registration.jpg)

Страница авторизации
![ScreenShot](images/login.jpg)

Добавление кандидата
![ScreenShot](images/candidate-creation.jpg)

Список кандидатов
![ScreenShot](images/candidates.jpg)

Список вакансий
![ScreenShot](images/posts.jpg)
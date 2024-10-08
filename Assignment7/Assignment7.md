# JPA and PostgreSQL Configuration and Testing in IntelliJ IDEA

## Introduction

This document provides a step-by-step guide on how we set up a development environment to persist data into a PostgreSQL database using **JPA** (Java Persistence API) and **Hibernate** as the ORM provider. The configuration was done using **IntelliJ IDEA** and its integrated database tools.

---

## Prerequisites

Before starting, make sure you meet the following requirements:

1. **PostgreSQL** installed and running.
2. **IntelliJ IDEA** with the JPA plugin enabled.
3. **JDK** and **Gradle** installed.
4. **Hibernate** and **PostgreSQL Driver** dependencies included in the project.

## Database Setup

### 1. Creating the Database in PostgreSQL

First, we accessed the PostgreSQL terminal and executed the following commands:

###bash
sudo service postgresql start
sudo -u postgres psql

Inside the PostgreSQL console, we created a new database and configured the user for access:

### 2. Creating the Schema and Tables

Within the same PostgreSQL console, we created the schema and necessary tables:
CREATE SCHEMA jpa_schema AUTHORIZATION jpa_client;
SET search_path TO jpa_schema;

CREATE TABLE address (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    street VARCHAR(255),
    number INTEGER
);
CREATE TABLE customer (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255)
);
-- Additional tables (CreditCard, Bank, Pincode, etc.) were created similarly.

### IntelliJ IDEA Configuration
### 1. Connecting to the Database
In IntelliJ IDEA, we configured the connection to the PostgreSQL database:

Open the Database panel.

Add a new connection and select PostgreSQL.

Set the connection details:

Host: 127.0.0.1
Port: 5432
Database: mydb
User: jpa_client
Password: password
Test the connection to ensure everything is working correctly.

###Hibernate and JPA Setup
### 1. persistence.xml File

We configured the persistence.xml file located in src/main/resources/META-INF/ to define the persistence unit, connection properties, and entity mappings. Here is the final version of the file:

<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
    version="3.0">
    <persistence-unit name="jpa-tutorial">
        <class>no.hvl.dat250.jpa.tutorial.creditcards.Customer</class>
        <class>no.hvl.dat250.jpa.tutorial.creditcards.Address</class>
        <class>no.hvl.dat250.jpa.tutorial.creditcards.Bank</class>
        <class>no.hvl.dat250.jpa.tutorial.creditcards.CreditCard</class>
        <class>no.hvl.dat250.jpa.tutorial.creditcards.Pincode</class>

        <properties>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://127.0.0.1:5432/mydb"/>
            <property name="jakarta.persistence.jdbc.user" value="jpa_client"/>
            <property name="jakarta.persistence.jdbc.password" value="password"/>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
        </properties>
    </persistence-unit>
</persistence>

### 2. Gradle Dependencies in build.gradle

I included the necessary dependencies in the build.gradle file:

dependencies {
    implementation 'org.hibernate.orm:hibernate-core:6.6.0.Final'
    implementation 'org.postgresql:postgresql:42.3.1'
    implementation 'jakarta.persistence:jakarta.persistence-api:3.0.0'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'
}

### Running Tests
Finally, we executed the CreditCardsMainTest.java to verify that entities were correctly persisted, and the database operations were running as expected.

### Test Output
Upon running the test, we observed the following output in the console, confirming that the persistence operations were successful:

![screenshot1](https://github.com/user-attachments/assets/605a438b-a21d-4844-8f26-1235f7059ce7)

# Dockerizing a Spring Boot Poll Application

## Introduction

This document outlines the steps taken to containerize an existing Spring Boot application (Poll App) as part of Experiment 2. The application provides a REST API for managing polls and vote options, and was successfully containerized using Docker. We utilized a multi-stage build to keep the final Docker image slim and efficient for distribution.

## Prerequisites

- **Docker** installed on your machine.
- **Gradle** for building the Spring Boot application.
- **Postman**, **Bruno**, or `curl` to test the API endpoints.

## Dockerfile Explanation

We created a Dockerfile for containerizing the Spring Boot Poll App. The Dockerfile uses a multi-stage build, with the following steps:

1. **Base Image**: We used `gradle:jdk21` for building the project and `eclipse-temurin:21-jdk` for running the final application.
2. **Build the Application**: We used `gradle bootJar` to compile and package the Spring Boot application.
3. **Multi-stage Build**: This technique helps reduce the size of the final image by only copying the required JAR file into the final runtime image.

### Dockerfile

# Stage 1: Build the application

FROM gradle:jdk21 AS build
COPY . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle bootJar

# Stage 2: Runtime

FROM eclipse-temurin:21-jdk AS runtime
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]

## Building and Running the Docker Image

To build and run the container, follow these steps:
Build the Docker image: From the root of your project directory (where the Dockerfile is located), run the following command:
docker build -t springboot-pollapp .

Run the Docker container: Once the image is built, you can run it using the following command:
docker run -p 8080:8080 springboot-pollapp

### Testing the API
We tested the API endpoints using Bruno (an API client similar to Postman) and the browser. The API exposes endpoints for managing polls, users, votes, and vote options. Here's an example of how to interact with the API:

## Example Request: Creating a Vote Option

![screenshot2](https://github.com/user-attachments/assets/6364f8f9-f4fa-47b4-bc09-96cbb16296a7)

![screenshot3](https://github.com/user-attachments/assets/916fbe0f-0bb3-4ff1-9047-7fc5d5955d0d)






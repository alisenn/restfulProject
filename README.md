# Java Spring Boot RESTful Service for RPN Calculator and Minesweeper Hints

## Overview
This repository contains a Spring Boot application implemented using Java 11. It offers two RESTful endpoints for the following tasks:

1. RPN Calculator (`/calculate`): To compute expressions written in Reverse Polish Notation.
2. Minesweeper Hints (`/show-hints`): To find all the mines in a given Minesweeper board and show hint numbers.

## Requirements
- Java 11
- Spring Boot
- Maven

## Building the Application

To build the application, navigate to the project directory and run:

```
mvn clean install
```

## Running the Application

To run the application, execute:

```
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## API Endpoints

### 1. RPN Calculator (`/calculate`)

**Request:**
```json
{
  "expression": "20 5 /"
}
```

**Response:**
```json
{
  "result": 4
}
```

#### Usage
```
POST /calculate
Content-Type: application/json

{
  "expression": "20 5 /"
}
```

### 2. Minesweeper Hints (`/show-hints`)

**Request:**
```json
{
  "square": ["**...", ".....", ".*..."]
}
```

**Response:**
```json
{
  "hints": ["**100","33200","1*100"]
}
```

#### Usage
```
POST /show-hints
Content-Type: application/json

{
  "square": ["**...", ".....", ".*..."]
}
```

## Testing

To run unit tests, execute:

```
mvn test
```

## Code Principles
- The codebase adheres to SOLID principles.
- Unit tests have been written for all cases.

## Author
Ali Şen
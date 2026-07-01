# CaseKaro Automation Assignment

## Overview

This project automates the process of adding multiple variants of a product to the cart on the CaseKaro website using Playwright with Java. The automation is integrated with Cucumber for BDD-style execution.

---

## Tech Stack

- Java
- Playwright
- Maven
- Cucumber
- JUnit

---

## Test Scenario

The automation performs the following steps:

1. Open the CaseKaro website.
2. Navigate to **Mobile Covers**.
3. Search for **iPhone 16 Pro**.
4. Open the product page.
5. Add the following material variants to the cart:
   - Hard
   - Soft
   - Glass
6. Open the shopping cart.
7. Verify that exactly **3 products** are present.
8. Print the following details for each product:
   - Product Name
   - Material
   - Price
   - Product Link

---

## Project Structure

```
CaseKaroAutomation
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.anand
│   │           └── BrowserL.java
│   │
│   └── test
│       ├── java
│       │   ├── runner
│       │   │   └── TestRunner.java
│       │   └── stepdefinitions
│       │       └── CaseKaroSteps.java
│       │
│       └── resources
│           └── features
│               └── casekaro.feature
│
├── pom.xml
└── README.md
```

---

## How to Run

Clone the repository

```bash
git clone <repository-url>
```

Go to the project directory

```bash
cd CaseKaroAutomation
```

Install dependencies

```bash
mvn clean install
```

Run the Cucumber test

```bash
mvn test
```

or execute the `TestRunner` class directly from IntelliJ IDEA.

---

## Expected Output

- All three material variants are successfully added to the cart.
- Cart contains exactly 3 products.
- Product details are printed in the console.

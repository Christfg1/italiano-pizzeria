# 🍕 Italiano Pizzeria

## Overview

Italiano Pizzeria is a Java console-based restaurant ordering application that allows customers to build custom pizzas, choose from signature pizzas, order drinks and garlic knots, and complete their order through a checkout system. The application demonstrates object-oriented programming principles, file handling, inheritance, polymorphism, encapsulation, and user interaction through a menu-driven interface.

The goal of this project is to simulate a real-world pizza ordering system while applying core Java concepts learned throughout the course.

---

## Features

### 🍕 Pizza Ordering

* Build Your Own Pizza
* Signature Pizza Menu
* Multiple Pizza Sizes
* Multiple Crust Types
* Stuffed Crust Option
* Multiple Sauce Selections
* Meat, Cheese, and Regular Toppings
* Extra Topping Options

### ⭐ Signature Pizzas

* Cheese Pizza
* Pepperoni Pizza
* Hawaiian Pizza
* Meat Lovers Pizza
* Veggie Pizza
* Supreme Pizza
* BBQ Chicken Pizza
* Italiano Special Pizza

### 🥤 Drinks

* Multiple Drink Sizes
* Multiple Drink Flavors

### 🧄 Garlic Knots

* Order Garlic Knots by Quantity

### 🧾 Checkout System

* View Order Summary
* Calculate Total Cost
* Confirm or Cancel Order
* Generate Receipt

### 💾 Receipt Saving

* Receipts are automatically saved as text files
* Receipt includes:

  * Date
  * Time
  * Ordered Items
  * Total Cost
* Saved inside:

```text
src/main/resources/receipts
```

### 🎨 User Experience

* Custom Italiano Pizzeria ASCII Logo
* ANSI Console Colors
* Italian Restaurant Theme
* Background Music
* Sound Effects
* Menu Navigation with Back Options

---

## Object-Oriented Programming Concepts

### Encapsulation

All class fields are private and accessed through public methods.

Example:

```java
private PizzaSize size;
private CrustType crust;
```

---

### Inheritance

All products inherit from the abstract Product class.

```text
Product
├── Pizza
├── Drink
└── GarlicKnots
```

---

### Polymorphism

Products are stored and managed through Product references.

```java
List<Product> products;
```

This allows different product types to be treated uniformly.

---

### Abstraction

The Product class is abstract and defines behavior shared by all products.

```java
public abstract class Product
```

---

### Enums

The application uses enums to manage fixed selections:

* PizzaSize
* CrustType
* SauceType
* DrinkFlavor
* DrinkSize
* SignaturePizzaType
* ToppingName
* ToppingCategory

---

## Project Structure

```text
com.italianopizzeria
│
├── models
│   ├── Product
│   ├── Pizza
│   ├── Drink
│   ├── GarlicKnots
│   ├── Topping
│   ├── Order
│   └── Receipt
│
├── services
│   ├── OrderManager
│   └── ReceiptFileManager
│
├── ui
│   ├── HomeScreen
│   ├── PizzaBuilderScreen
│   ├── DrinkScreen
│   ├── CheckOutScreen
│   └── ConsoleHelper
│
├── enums
│   ├── PizzaSize
│   ├── CrustType
│   ├── SauceType
│   ├── DrinkFlavor
│   ├── DrinkSize
│   ├── SignaturePizzaType
│   ├── ToppingName
│   └── ToppingCategory
│
└── utilities
    ├── ConsoleColors
    ├── TextFormatter
    ├── DateUtils
    └── FileUtils
```

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/yourusername/italiano-pizzeria.git
```

2. Open the project in IntelliJ IDEA

3. Run:

```java
ItalianoPizzeria.java
```

4. Follow the menu prompts to place an order.

---

## Sample Receipt

```text
========================================
          ITALIANO PIZZERIA
========================================

Date: May 29, 2026
Time: 4:42 PM

Pepperoni Pizza - $15.50
Coke - $2.50

----------------------------------------
TOTAL: $18.00
----------------------------------------

Thank you for ordering!
Buon Appetito! 🍕
```

---

## Technologies Used

* Java
* IntelliJ IDEA
* Object-Oriented Programming
* Java Collections
* File I/O
* Enums
* Exception Handling
* ANSI Console Styling

---

## Future Improvements

* Remove Items From Order
* Customer Accounts
* Delivery Orders
* Coupons and Discounts
* Database Integration
* GUI Version
* Online Ordering System

---

## Author

Christian Fonseca

Year Up United – Application Development

Java Capstone Project

2026

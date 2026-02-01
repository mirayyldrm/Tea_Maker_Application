# ☕️ Tea Maker Application

A simulation of a smart tea maker machine developed with **Java** and **Swing UI**. This project demonstrates the practical implementation of key **Software Design Patterns** and robust **MySQL database** integration.

## Key Features

| Feature                        | Description                                                                                                          |
| :----------------------------- | :------------------------------------------------------------------------------------------------------------------- |
| **State-Driven Simulation**    | Robust simulation of machine life-cycle states (Empty, Idle, Boiling, Making Tea, Done) using the **State Pattern**. |
| **Reactive User Interface**    | Dynamic **Java Swing** interface that updates LED indicators, buttons, and messages in real-time via the **Observer Pattern**. |
| **Data Persistence & Logging** | Seamless integration with **MySQL** to securely track, store, and retrieve daily and monthly tea consumption records. |
| **Smart Health Alerts**        | Intelligent warning system utilizing the **Decorator Pattern** to notify users when daily caffeine intake limits are exceeded. |
| **Context-Aware Controls**     | Interactive control panel where buttons (Fill, Start, Boil, Reset) automatically enable or disable based on the active state. |
| **Automated Brewing Process**  | Simulates realistic time delays for water boiling and tea steeping processes using asynchronous timers. |
| **Consumption Analytics**      | Provides instant visual feedback on total cups consumed directly from the database with a single click. |


## Design Patterns Implemented

| Pattern               | Implementation & Role                                                                                                                                          |
| :-------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **State Pattern**     | Manages complex state transitions (e.g., `IdleState`, `BoilingWaterState`) by encapsulating behaviors, effectively eliminating complex `if-else` logic chains. |
| **Observer Pattern**  | Establishes a subscription mechanism where `TeaMakerView` listens to `TeaMakerModel`, ensuring real-time UI updates without tight coupling. |
| **Singleton Pattern** | Guarantees that the `DatabaseHelper` class has only **one** single instance globally, optimizing resource usage for database connections. |
| **Decorator Pattern** | Dynamically extends object responsibilities; used in `HealthWarningDecorator` to inject health alerts into messages without altering the core class code. |


## 🛠Technology Stack

| Category                 | Technologies  |
| :----------------------- | :------------ |
| **Programming Language** | Java (JDK 21) |
| **IDE**                  | IntelliJ IDEA |
| **GUI Framework**        | Java Swing (javax.swing) |
| **Database**             | MySQL |
| **Database Access**      | JDBC (MySQL Connector/J) |
| **Architecture**         | MVC (Model-View-Controller) based |
| **Key Concepts**         | OOP, Design Patterns, Multithreading |


## Setup & Installation
1.  Download the project zip file or clone the repo.
2.  Import the `tea_maker_db.sql` file into your local MySQL server.
3.  Open the project in **IntelliJ IDEA**.
4.  Update the `DatabaseHelper.java` file with your own MySQL username and password.
5.  Run `Main.java` to start the application.

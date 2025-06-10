-----

# ✈️ Airline Reservation System

A simple console-based Airline Reservation System built with Java. This system allows administrators to manage flight details and customers to book, view, and cancel flight tickets.

-----

## ✨ Features

### Admin Module

  * **View Flight Details**: See a comprehensive list of all available flights, including their numbers, destinations, prices, times, and available seats.
  * **Add New Flights**: Administrators can add new flight routes with unique flight numbers, destinations, prices, and departure times. The system ensures unique flight numbers.
  * **Delete Existing Flights**: Remove flights from the system using their flight number.
  * **Change Admin Password**: Securely update the administrator's login password.
  * **Login Attempts**: Admins have a limited number of login attempts before being locked out.

### Customer Module

  * **Account Creation**: New users can create an account with an email (validated for `@gmail.com` domain) and a password (minimum 8 characters).
  * **User Login**: Existing users can log in to their accounts to access booking features.
  * **Book Tickets**: Customers can book multiple seats on available flights. The system checks for seat availability.
  * **View Booked Tickets**: Retrieve and display booking details using a unique ticket number.
  * **Cancel Tickets**: Cancel existing bookings using the ticket number, which then makes the seats available again.

-----

## 🚀 Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

  * **Java Development Kit (JDK)**: Make sure you have JDK 8 or higher installed. You can download it from the [Oracle website](https://www.oracle.com/java/technologies/downloads/).

### Installation

1.  **Save the Code**: Save all the provided Java code into a single file named `Main.java`.
2.  **Open Terminal/Command Prompt**: Navigate to the directory where you saved the `Main.java` file.
3.  **Compile the code**:
    ```bash
    javac Main.java
    ```
    This command compiles all the necessary classes.

-----

## 🎮 How to Use

1.  **Run the application**:

    ```bash
    java Main
    ```

2.  **Main Menu**:
    Upon launching, you will be greeted with a welcome message and presented with the main menu:

      * **1. For Admin**: Access the administrator functionalities.
      * **2. For Customer**: Access the customer functionalities (login/create account, book tickets, etc.).
      * **3. For Exit**: Exit the application.

### Admin Access

1.  Select `1` from the main menu.
2.  You will be prompted to enter the **Admin Password**. The default password is `1234`. You have 3 attempts.
3.  Once logged in, you can choose from options like showing flight details, adding/deleting flights, or changing the admin password.

### Customer Access

1.  Select `2` from the main menu.
2.  You will be prompted to **Create Account** or **Login**.
      * **Create Account**: Enter your email (must end with `@gmail.com`) and a password (minimum 8 characters).
      * **Login**: Enter your registered email and password.
3.  After successful login, you can:
      * Book tickets for available flights.
      * View details of your booked tickets.
      * Cancel your booked tickets.

-----

## 📂 Project Structure

The project is organized into several classes, each responsible for a specific part of the system:

  * **`Airport`**: Manages flight details (flight names, numbers, prices, destinations, times, and available seats). It includes methods for displaying, adding, and deleting flights.
  * **`Admin`**: Handles administrator login and provides a menu for managing flights and changing the admin password.
  * **`flight`**: Extends `Airport` and manages ticket booking, searching for tickets, and canceling tickets.
  * **`Customer_data`**: Manages customer accounts, including email and password validation for registration and login.
  * **`Customer`**: Provides the customer interface for interacting with flight booking functionalities after login.
  * **`Main`**: The entry point of the application, which displays the initial welcome message and allows users to choose between Admin and Customer modules.

-----

## ⚠️ Important Notes

  * **Data Persistence**: This is a console-based application, and all data (flight details, customer accounts, bookings) is stored in memory. When the application is closed, all changes will be lost.
  * **Error Handling**: Basic input validation and error messages are implemented.
  * **Security**: The admin password and customer passwords are hardcoded and stored in arrays. For a real-world application, a more robust security mechanism and database integration would be required.

-----

## 🤝 Contributing

Feel free to fork this repository, suggest improvements, or submit pull requests.

-----

## ✒️ Author

Dhruvil Thummar 

-----

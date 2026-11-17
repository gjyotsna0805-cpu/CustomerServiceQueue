# 🏦 Customer Service Queue Management System

A **Java-based Customer Service Queue Management System** that efficiently manages customers waiting at a service counter using the **Queue Data Structure implemented with a Singly Linked List**.

The application allows customers to join the queue, receive unique token numbers, get served in FIFO order, view the waiting queue, and leave the queue using their token number.

It also uses **File Handling** to store customer information permanently, ensuring data is available even after restarting the application.

## ✨ Features

- 🎟️ **Join Queue:** Add new customers and automatically generate unique token numbers (Q101, Q102, Q103...).
- 📢 **Call Next Customer:** Serve customers in FIFO (First In, First Out) order.
- 📋 **Display Queue:** View all customers currently waiting in the queue.
- 🚪 **Leave Queue:** Allow customers to leave the queue using their token number.
- 👥 **People Ahead:** Display the number of customers waiting ahead.
- 💾 **File Handling:** Automatically save customer details in `customers.txt`.
- 🔄 **Data Persistence:** Restore previously saved customer records when the application starts.
- 🔢 **Automatic Token Management:** Maintain continuous token numbering even after restarting the application.

## 🛠️ Technologies Used

- ☕ **Programming Language:** Java
- 📚 **Data Structure:** Queue
- 🔗 **Implementation:** Singly Linked List
- 🧠 **Concepts:** Classes, Objects, Constructors, Methods, File Handling, Exception Handling
- 📦 **Java Libraries:** `java.io.*`, `java.util.*`

## 📁 Project Structure

```text
CustomerServiceQueue/
│
├── CustomerServiceQueue.java
├── customers.txt          # Automatically generated
└── README.md
```

## ⚙️ Installation & Setup

### 📌 Prerequisites

- Java Development Kit (JDK 8 or above)
- VS Code / IntelliJ IDEA / Eclipse
- Basic knowledge of Java

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/CustomerServiceQueue.git
```

### 2️⃣ Navigate to the Project Folder

```bash
cd CustomerServiceQueue
```

### 3️⃣ Compile the Java Program

```bash
javac CustomerServiceQueue.java
```

### 4️⃣ Run the Application

```bash
java CustomerServiceQueue
```

## 🖥️ Application Menu

After running the program, the following menu will appear:

```text
===== CUSTOMER SERVICE QUEUE =====

1. Join Queue
2. Call Next Customer
3. Display Queue
4. Leave Queue
5. Exit

Enter your choice:
```

## 📸 Sample Output

### 🎟️ 1. Join Queue

```text
Enter your choice: 1

Enter Customer Name: Rahul
Enter Service Required: Banking

Token issued.
Q101 | Rahul | Banking | People ahead: 0
```

### 👤 2. Add Another Customer

```text
Enter your choice: 1

Enter Customer Name: Priya
Enter Service Required: Account Opening

Token issued.
Q102 | Priya | Account Opening | People ahead: 1
```

### 📋 3. Display Queue

```text
Enter your choice: 3

Customer Queue:
1. Q101 | Rahul | Banking
2. Q102 | Priya | Account Opening
```

### 📢 4. Call Next Customer

```text
Enter your choice: 2

Now serving: Q101 | Rahul
Remaining in queue: 1
```

### 🚪 5. Leave Queue

```text
Enter your choice: 4

Enter Token Number: Q102

Token Q102 removed from the queue.
```

### 👋 6. Exit Application

```text
Enter your choice: 5

Data saved successfully.
Thank you for using the system!
```

## 💾 File Handling & Data Persistence

The application uses a text file named `customers.txt` to store customer records.

**Example:**

```text
NEXT_TOKEN=103
Q101|Rahul|Banking
Q102|Priya|Account Opening
```

🔹 Customer information is automatically saved whenever the queue changes.

🔹 Existing customer records are loaded when the application starts.

🔹 The next token number is maintained to avoid duplicate tokens.

🔹 Served or removed customers are deleted from the active queue records.

## 🧠 Core Concepts Implemented

| Concept | Description |
|---|---|
| 📚 Queue | Follows FIFO order |
| 🔗 Singly Linked List | Dynamically stores customer records |
| 🏗️ Classes & Objects | Represents customers and queue operations |
| 💾 File Handling | Saves and retrieves customer data |
| ⚠️ Exception Handling | Handles invalid inputs and file errors |
| ⚙️ Methods | Separates different queue operations |

## 🚀 Future Enhancements

- 🖥️ Add a Graphical User Interface (GUI).
- ⭐ Introduce priority-based customer service.
- 🔍 Add customer search functionality.
- 📊 Generate daily service reports.
- 🗄️ Integrate a database such as MySQL.

## 🎯 Learning Outcomes

Through this project, I learned how to:

- Implement a Queue using a Singly Linked List.
- Understand and apply the FIFO principle.
- Perform insertion and deletion operations.
- Work with File Handling in Java.
- Maintain data persistence using text files.
- Handle invalid user inputs and exceptions.

## 👩‍💻 Author

**Jyotsna G.**

🎓 B.Tech – Computer Science and Engineering

---

⭐ **If you find this project useful, don't forget to give this repository a star!**

💡 *Learning by building, growing by coding!*

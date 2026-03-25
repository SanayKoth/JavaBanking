# 🏦 Java Banking Application

A simple console-based banking system built in Java to demonstrate core **Object-Oriented Programming (OOP)** principles and basic system design.

---

## 🚀 Features

* Create new bank accounts
* Login to existing accounts
* Deposit money
* Withdraw money
* Check account balance
* View transaction history
* Multi-user support (multiple accounts managed in memory)

---

## 🧠 Concepts Demonstrated

This project showcases:

* **Encapsulation** (private fields with getters)
* **Abstraction** (clean separation between UI, service, and model layers)
* **Composition** (`Account` contains `Transaction` objects)
* **Collections Framework**

  * `HashMap` for efficient account lookup
  * `ArrayList` for transaction history
* **Basic system design**

  * Layered architecture:

    * `model` → data classes
    * `service` → business logic
    * `ui` → user interaction

---

## 📂 Project Structure

```
src/
│
├── model/
│   ├── Account.java
│   └── Transaction.java
│
├── service/
│   └── Bank.java
│
└── ui/
    └── Main.java
```

---

## ⚙️ How It Works

* The `Bank` class manages all accounts using a `HashMap`
* Users interact through a console menu (`Main`)
* Each `Account` stores its own balance and transaction history
* Every deposit/withdrawal is logged as a `Transaction`

---

## 🖥️ How to Run

1. Clone the repository:

   ```
   git clone https://github.com/SanayKoth/JavaBanking.git
   ```

2. Open in an IDE (IntelliJ recommended)

3. Run:

   ```
   src/ui/Main.java
   ```

---

## 🔄 Example Flow

```
1. Create Account
2. Login
3. Deposit
4. Withdraw
5. View Transactions
6. Logout
```

---

## 🚧 Future Improvements

* Add account **PIN authentication**
* Implement **money transfer between accounts**
* Persist data using **file storage or database**
* Add a graphical user interface (GUI)

---

## 📌 Author

Sanay Kothalkar

---

## ⭐ Notes

This project is designed for learning purposes and demonstrates how core programming concepts can be applied to simulate a real-world system.

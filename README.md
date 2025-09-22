# Travel_Agency_Project

A Java-based backend application for managing bus travel bookings. This system allows admins to handle customer data, apply cancellation policies, and calculate refunds with precision. Built using JDBC and MySQL, it features a clean menu-driven interface for efficient operations.

## 📌 Features

- Add, view, update, and delete customer bookings
- Cancel bookings with automatic refund calculation
- **30% discount for female passengers**
- **20% price hike on weekend travel dates**
- Fetch refund amount dynamically from database
- Search bookings by mobile number
- Console-based admin interface with error handling

## 🛠️ Technologies Used

- **Java** (JDK 17+)
- **JDBC** for database connectivity
- **MySQL** for data storage
- **Git** for version control

## 🗃️ Database Schema

### Table: `customer`

| Column Name         | Data Type | Description                        |
|---------------------|-----------|------------------------------------|
| `Name`              | VARCHAR   | Passenger's full name              |
| `MobileNo`          | VARCHAR   | Unique mobile number               |
| `Gender`            | VARCHAR   | Gender of the passenger            |
| `Email`             | VARCHAR   | Contact email                      |
| `month`             | INT       | Month of travel                    |
| `date`              | INT       | Date of travel                     |
| `Boarding_point`    | VARCHAR   | Starting location                  |
| `Destination_point` | VARCHAR   | Destination location               |
| `Bus_type`          | VARCHAR   | Type of bus (e.g., AC, Non-AC)     |
| `Amount`            | DOUBLE    | Total booking amount               |

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yuvarajgit-2505/Travel_Agency_Project.git
   ```

2. Set up the MySQL database and create the `customer` table using the schema above.

3. Update your `DBConnection.java` with correct database credentials.

4. Compile and run the project:
   ```bash
   javac Main.java
   java Main
   ```

## 📂 Project Structure

```
src/
├── DBConnection.java
├── CustomerDAO.java
├── TravelAgency.java
└── Main.java
```

## 💸 Cancellation & Refund Logic

When a booking is cancelled, the system:

- Retrieves the original `Amount` from the database
- Applies a **30% deduction** as per cancellation policy
- Applies a **30% discount** if the passenger is female
- Applies a **20% price hike** if the travel date falls on a weekend (Saturday or Sunday)
- Displays the final refund amount

### Sample Output:
```
Your booking has been cancelled.
Weekend travel: 20% price hike applied.
Female passenger: 30% discount applied.
Refund amount: ₹1050.0
```

## 🙋‍♂️ Author

**Yuvaraj**  
Backend Developer | Java | JDBC | MySQL  
GitHub: [yuvarajgit-2505](https://github.com/yuvarajgit-2505)

## 📃 License

This project is licensed under the MIT License.

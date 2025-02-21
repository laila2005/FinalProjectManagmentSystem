# Project Management System

## Overview
The Project Management System is a comprehensive software designed to manage and streamline project tasks, resources, and team collaboration. It integrates a SQL Server database with a Java-based NetBeans application, ensuring robust and efficient management of projects.

---

## Features
- **User Authentication:** Secure login system for administrators and users.
- **Project Management:** Create, update, and delete projects.
- **Task Assignment:** Assign tasks to team members with deadlines.
- **Resource Allocation:** Manage resources effectively.
- **Reporting:** Generate reports for project progress.
- **Database Integration:** Uses SQL Server for data storage and retrieval.

---

## Technologies Used
- **Frontend:** Java Swing (NetBeans IDE)
- **Backend:** SQL Server
- **Driver:** Microsoft SQL Server JDBC Driver
- **Database:** SQL Server (Version 2019 or higher)

---

## Database Structure
### Key Tables:
1. **Users**: Stores user details and roles.
2. **Projects**: Manages project information.
3. **Tasks**: Tracks task assignments and progress.
4. **Resources**: Allocates and monitors resources.

---

## Setup Instructions

### Prerequisites
1. Install **SQL Server** and **SQL Server Management Studio (SSMS)**.
2. Install **NetBeans IDE** with JDK 8 or higher.
3. Download the **Microsoft SQL Server JDBC Driver**.

### Database Configuration
1. Open **SQL Server Management Studio**.
2. Create a new database named `ProjectManagementDB`.
3. Use the provided `Schema.sql` file to create tables and relationships.
4. Add a new SQL Server login and grant access to the database (refer to the instructions in this document).

### Application Configuration
1. Open the project in **NetBeans IDE**.
2. Add the JDBC driver to the project's libraries:
   - Right-click on the project > **Properties** > **Libraries** > **Add JAR/Folder**.
   - Select the JDBC driver JAR file.
3. Update the connection string in the Java code:
   ```java
   String url = "jdbc:sqlserver://<SERVER_NAME>:1433;databaseName=ProjectManagementDB;encrypt=false";
   String username = "<USERNAME>";
   String password = "<PASSWORD>";
   ```
4. Build and run the project.

---

## How to Use
1. Launch the application from NetBeans.
2. Log in using your credentials.
3. Navigate through the system to:
   - Create or manage projects.
   - Assign and monitor tasks.
   - Allocate resources.
   - Generate and view reports.

---

## Troubleshooting
- **Connection Issues**:
  - Ensure the SQL Server instance is running.
  - Verify that TCP/IP is enabled in SQL Server Configuration Manager.
  - Ensure the firewall allows connections on port `1433`.
- **Driver Errors**:
  - Confirm the JDBC driver is correctly added to the project.

---

## Future Enhancements
- Integration with cloud services for remote access.
- Mobile-friendly interface.
- Enhanced reporting with data visualization.

---

## Contributors
- **Laila Mohamed Fikry**
  - Software Engineer at Egyptian Russian University
  - ALX and Holberton School Graduate
- **Sara Ahmed Mohamed**
 - Software Engineer at Egyptian Russian

---

## License
This project is licensed under the MIT License. See `LICENSE` for details.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectmanagmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 /
 * @author dell
 */
public class DatabaseConnection {
    public static void main(String[] args) {
        // JDBC URL and credentials
        String url = "jdbc:sqlserver://LAILA-MOHAMED-P\\\\dell:1433;databaseName=ProjectManagementDB;encrypt=true;trustServerCertificate=true";
        String user = "medfy";    
        String password = "medfylolo"; 
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // SQL Server JDBC Driver
        
        // Declare connection objects
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load JDBC driver
            Class.forName(driver);

            // Establish the connection
            conn = DriverManager.getConnection(url,user , password);
            System.out.println("Database connection established successfully!");

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            String query = "SELECT * FROM Task";
            rs = stmt.executeQuery(query);

            // Print results
            System.out.println("\n--- Task Table Contents ---");
            while (rs.next()) {
                System.out.println("Task ID: " + rs.getInt("Task_ID") +
                                   ", Task Name: " + rs.getString("Task_Name") +
                                   ", Assigned To: " + rs.getString("Assigned_To") +
                                   ", Due Date: " + rs.getDate("Due_Date"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("Resources closed successfully.");
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}

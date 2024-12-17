/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalprojectmanagmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Main {

    // Updated database credentials
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=ProjectManagementDB;encrypt=true;trustServerCertificate=true;";
    private static final String DB_USER = "laila_mf";
    private static final String DB_PASSWORD = "medfylolo";
    
    public static void main(String[] args) {
        // Attempt to connect to the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to the database successfully!");

            Scanner scanner = new Scanner(System.in);
            UserManager userManager = new UserManager(connection);

            // Main loop for user interaction
            OUTER:
            while (true) {
                System.out.println("\n--- Project Management System ---");
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");

                // Ensure input is valid
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Menu handling
                switch (choice) {
                    case 1 -> userManager.login(scanner);
                    case 2 -> {
                        System.out.println("Exiting system. Goodbye!");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }
}
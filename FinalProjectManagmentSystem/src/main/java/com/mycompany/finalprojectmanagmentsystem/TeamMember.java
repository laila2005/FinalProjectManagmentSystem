/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectmanagmentsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author dell
 */
public class TeamMember {
    private final String username;
    private final Connection connection;

    public TeamMember(String username, Connection connection) {
        this.username = username;
        this.connection = connection;
    }
    public String getUsername() {
        return username;
    }

    public Connection getConnection() {
        return connection;
    }

    public void menu(Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("\n--- Team Member Menu ---");
            System.out.println("1. View My Tasks");
            System.out.println("2. Update Task Status");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewTasks();
                case 2 -> updateTaskStatus(scanner);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

     protected void viewTasks() throws SQLException {
        String query = "SELECT * FROM tasks WHERE assigned_to = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n--- My Tasks ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("task_name") + ", Deadline: " + rs.getString("deadline") + ", Status: " + rs.getString("status"));
            }
        }
    }

    protected  void updateTaskStatus(Scanner scanner) throws SQLException {
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new status (To-Do, On-Going, Done): ");
        String newStatus = scanner.nextLine();

        String query = "UPDATE tasks SET status = ? WHERE id = ? AND assigned_to = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, taskId);
            stmt.setString(3, username);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Task status updated successfully!");
            } else {
                System.out.println("Failed to update task status. Ensure the task is assigned to you.");
            }
        }
    } 
}

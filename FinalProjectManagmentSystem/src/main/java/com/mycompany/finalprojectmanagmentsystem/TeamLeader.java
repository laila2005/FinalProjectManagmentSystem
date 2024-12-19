package com.mycompany.finalprojectmanagmentsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class TeamLeader extends TeamMember {

    public TeamLeader(String username, Connection connection) {
        super(username, connection); // Calls the constructor of TeamMember
    }

    @Override
    public void menu(Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("\n--- Team Leader Menu ---");
            System.out.println("1. View My Tasks");
            System.out.println("2. Update Task Status");
            System.out.println("3. Create Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Assign Task");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewTasks(); // Inherited from TeamMember
                case 2 -> updateTaskStatus(scanner); // Inherited from TeamMember
                case 3 -> createTask(scanner);
                case 4 -> viewAllTasks();
                case 5 -> assignTask(scanner);
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createTask(Scanner scanner) throws SQLException {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();
        System.out.print("Enter status (To-Do, On-Going, Done): ");
        String status = scanner.nextLine();

        String query = "INSERT INTO Task (task_name, deadline, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setString(1, taskName);
            stmt.setString(2, deadline);
            stmt.setString(3, status);
            stmt.executeUpdate();
            System.out.println("Task created successfully!");
        }
    }

    private void viewAllTasks() throws SQLException {
        String query = "SELECT * FROM Task";
        try (PreparedStatement stmt = getConnection().prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("\n--- All Tasks ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Task_ID") + ", Name: " + rs.getString("Task_Name") +
                        ", Deadline: " + rs.getString("Deadline") + ", Status: " + rs.getString("Status"));
            }
        }
    }


    private void assignTask(Scanner scanner) throws SQLException {
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter username to assign task to: ");
        String assignedTo = scanner.nextLine();

        String query = "UPDATE Task SET assigned_to = ? WHERE id = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setString(1, assignedTo);
            stmt.setInt(2, taskId);
            stmt.executeUpdate();
            System.out.println("Task assigned successfully!");
        }
    }
}

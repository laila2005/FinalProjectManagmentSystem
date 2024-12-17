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
public class UserManager {
     private final Connection connection;

    public UserManager(Connection connection) {
        this.connection = connection;
    }

    public void login(Scanner scanner) throws SQLException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

       String query = "SELECT * FROM User WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                boolean is_leader = rs.getBoolean("is_leader");
                System.out.println("Login successful! Welcome, " + username + ".");
                if (is_leader) {
                    TeamLeader leader = new TeamLeader(username, connection);
                    leader.menu(scanner);
                } else {
                    TeamMember member = new TeamMember(username, connection);
                    member.menu(scanner);
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        }
    }
}

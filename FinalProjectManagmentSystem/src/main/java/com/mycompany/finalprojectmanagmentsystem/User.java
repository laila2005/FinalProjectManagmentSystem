/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectmanagmentsystem;

/**
 *
 * @author dell
 */
public class User {
    private String username;
    private String password;
    private boolean isLeader;

    public User(String username, String password, boolean isLeader) {
        this.username = username;
        this.password = password;
        this.isLeader = isLeader;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLeader() {
        return isLeader;
    }
}
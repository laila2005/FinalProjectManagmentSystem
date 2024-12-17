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
    private boolean is_leader;

    public User(String username, String password, boolean is_leader) {
        this.username = username;
        this.password = password;
        this.is_leader = is_leader;
    }

    public String getUsername() {
        return username;
    }

    public boolean is_leader() {
        return is_leader;
    }
}
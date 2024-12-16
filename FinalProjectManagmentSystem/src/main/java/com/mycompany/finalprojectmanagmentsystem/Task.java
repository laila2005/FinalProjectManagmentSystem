/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprojectmanagmentsystem;

/**
 *
 * @author dell
 */
public class Task {
    private int id;
    private String taskName;
    private String deadline;
    private String status;
    private String assignedTo;

    public Task(int id, String taskName, String deadline, String status, String assignedTo) {
        this.id = id;
        this.taskName = taskName;
        this.deadline = deadline;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }
}

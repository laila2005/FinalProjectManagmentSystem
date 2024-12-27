-- Create Database
CREATE DATABASE ProjectManagementDB;

USE ProjectManagementDB;


-- Create Project Table
CREATE TABLE Project (
    project_ID INT IDENTITY PRIMARY KEY,
    project_Name NVARCHAR(100) NOT NULL,
    start_Date DATE NOT NULL,
    End_Date DATE
);


-- Create User Table
CREATE TABLE [User] (
    user_id INT IDENTITY PRIMARY KEY,
    username NVARCHAR(50) UNIQUE NOT NULL,
    password NVARCHAR(255) NOT NULL
);


-- Create Task Table
CREATE TABLE Task (
    Task_ID INT IDENTITY PRIMARY KEY,
    Task_Name NVARCHAR(100) NOT NULL,
    Deadline DATE,
    Status NVARCHAR(50) NOT NULL,
    Priority NVARCHAR(10) CHECK (Priority IN ('high', 'medium', 'low'))
);


-- Create Assigned_Tasks Table
CREATE TABLE Assigned_Tasks (
    assignment_id INT IDENTITY PRIMARY KEY,
    Task_ID INT NOT NULL,
    user_id INT NOT NULL,
    assigned_date DATE,
    completion_date DATE,
    hours_worked INT,
    FOREIGN KEY (Task_ID) REFERENCES Task(Task_ID),
    FOREIGN KEY (user_id) REFERENCES [User](user_id)
);


-- Create Works_On Table (Relationship between Tasks and Users)
CREATE TABLE Works_On (
    Task_ID INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (Task_ID, user_id),
    FOREIGN KEY (Task_ID) REFERENCES Task(Task_ID),
    FOREIGN KEY (user_id) REFERENCES [User](user_id)
);
--inserting sample data 
INSERT INTO [User] (username, password, is_leader) VALUES('username', 'password', 1); -- 1 for leader 0 for team member